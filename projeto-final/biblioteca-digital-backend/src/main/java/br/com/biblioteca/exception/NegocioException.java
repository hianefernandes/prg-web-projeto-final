// Define o pacote de exceções da aplicação
package br.com.biblioteca.exception;

/**
 * Exceção personalizada para regras de negócio.
 * 
 * Essa classe é utilizada quando alguma regra do sistema
 * é violada durante a execução das operações.
 * 
 * Exemplos:
 * - tentar realizar um empréstimo sem usuário
 * - tentar realizar um empréstimo sem exemplar
 * - tentar devolver um livro já devolvido
 */
public class NegocioException extends RuntimeException {

    /**
     * Construtor que recebe a mensagem de erro.
     * 
     * A mensagem será exibida ao usuário através
     * do GlobalExceptionHandler.
     *
     * @param mensagem descrição do erro de negócio
     */
    public NegocioException(String mensagem) {
        // Chama o construtor da classe RuntimeException
        super(mensagem);
    }
}