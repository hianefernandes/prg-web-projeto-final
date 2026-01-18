package br.com.biblioteca.exception;

/**
 * Exceção de regra de negócio.
 * 
 * Essa classe será usada quando alguma regra do sistema
 * for violada, por exemplo:
 * - tentar salvar um empréstimo sem usuário
 * - tentar salvar um empréstimo sem exemplar
 */
public class NegocioException extends RuntimeException {

    /**
     * Construtor que recebe a mensagem de erro
     * @param mensagem descrição do erro de negócio
     */
    public NegocioException(String mensagem) {
        super(mensagem);
    }
}