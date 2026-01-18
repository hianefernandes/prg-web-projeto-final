package br.com.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável por capturar exceções de forma global
 * em toda a aplicação.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Trata exceções de regra de negócio.
     *
     * @param ex exceção lançada pelo Service
     * @return resposta HTTP com mensagem de erro
     */
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> tratarNegocioException(NegocioException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    /**
     * Trata erros de validação do DTO (@Valid).
     *
     * @param ex exceção gerada quando algum campo inválido
     * @return mapa com os erros de validação
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarValidacaoException(MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();

        // Percorre todos os erros de validação
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            erros.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(erros);
    }

    /**
     * Trata qualquer outra exceção não prevista.
     *
     * @param ex exceção genérica
     * @return mensagem de erro padrão
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> tratarExceptionGeral(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro interno no servidor.");
    }
}