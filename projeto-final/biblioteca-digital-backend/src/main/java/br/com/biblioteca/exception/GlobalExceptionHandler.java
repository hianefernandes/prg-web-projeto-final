// Define o pacote responsável pelas exceções da aplicação.
// Centralizar exceções facilita a manutenção e padroniza respostas.
package br.com.biblioteca.exception;

// Importa os códigos de status HTTP (400, 500, etc.)
import org.springframework.http.HttpStatus;
// Importa a classe utilizada para construir respostas HTTP personalizadas
import org.springframework.http.ResponseEntity;
// Importa a exceção lançada quando validações do @Valid falham
import org.springframework.web.bind.MethodArgumentNotValidException;
// Indica que esta classe irá interceptar exceções de forma global
import org.springframework.web.bind.annotation.ControllerAdvice;
// Indica métodos responsáveis por tratar exceções específicas
import org.springframework.web.bind.annotation.ExceptionHandler;

// Importa implementação de Map para armazenar erros de validação
import java.util.HashMap;
// Importa a interface Map
import java.util.Map;

/**
 * Classe responsável por capturar exceções de forma global
 * em toda a aplicação.
 * 
 * Evita tratamento de erros repetido nos controllers
 * e padroniza as respostas de erro para o frontend.
 */
@ControllerAdvice
// Indica que esta classe observa todos os controllers da aplicação
public class GlobalExceptionHandler {

    /**
     * Trata exceções de regra de negócio.
     * 
     * Essa exceção normalmente é lançada na camada de Service
     * quando alguma regra do sistema é violada.
     *
     * @param ex exceção lançada pelo Service
     * @return resposta HTTP com status 400 e mensagem de erro
     */
    // Define que este método irá tratar exceções do tipo NegocioException
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> tratarNegocioException(NegocioException ex) {
        return ResponseEntity
                // Define o status HTTP como 400 (Bad Request)
                .status(HttpStatus.BAD_REQUEST)
                // Retorna a mensagem definida na exceção
                .body(ex.getMessage());
    }

    /**
     * Trata erros de validação provenientes do uso do @Valid nos DTOs.
     * 
     * Essa exceção ocorre quando algum campo obrigatório
     * não é preenchido ou está em formato inválido.
     *
     * @param ex exceção gerada durante a validação
     * @return mapa contendo campo e mensagem de erro
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    // Define o tratamento para erros de validação
    public ResponseEntity<?> tratarValidacaoException(MethodArgumentNotValidException ex) {

        // Cria um mapa para armazenar os erros de validação
        // A chave será o nome do campo e o valor a mensagem de erro
        Map<String, String> erros = new HashMap<>();

        // Percorre todos os erros de validação encontrados
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            // Para cada erro, adiciona o nome do campo e a mensagem padrão
            erros.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity
                // Retorna status HTTP 400 indicando erro na requisição
                .status(HttpStatus.BAD_REQUEST)
                // Retorna o mapa de erros para o frontend
                .body(erros);
    }

    /**
     * Trata qualquer outra exceção não prevista explicitamente.
     * 
     * Serve como uma proteção para evitar que erros internos
     * sejam expostos diretamente ao usuário.
     *
     * @param ex exceção genérica capturada
     * @return mensagem padrão de erro interno
     */
    @ExceptionHandler(Exception.class)
    // Captura qualquer exceção não tratada anteriormente
    public ResponseEntity<?> tratarExceptionGeral(Exception ex) {
        return ResponseEntity
                // Retorna status HTTP 500 (Erro interno do servidor)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                // Retorna uma mensagem genérica
                .body("Erro interno no servidor.");
    }
}