// Define o pacote de exceções
package br.com.biblioteca.exception;

/**
 * Exceção lançada quando um recurso não é encontrado.
 * 
 * Normalmente utilizada quando um ID informado
 * não existe no banco de dados.
 * 
 * Exemplo:
 * - buscar usuário por ID inexistente
 * - tentar deletar um livro que não existe
 */

public class RecursoNaoEncontradoException extends RuntimeException {
    
    /**
     * Construtor que recebe a mensagem de erro.
     *
     * @param mensagem mensagem informando que o recurso não foi encontrado
     */
    public RecursoNaoEncontradoException(String mensagem) {
        // Chama o construtor da exceção pai
        super(mensagem);
    }
}
