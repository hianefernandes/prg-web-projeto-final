// Define o pacote repository
package br.com.biblioteca.repository;

// Importa a entidade Livro
// Representa a tabela "livros" no banco de dados
import br.com.biblioteca.entity.Livro;
// Importa o JpaRepository
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository responsável pelas operações
 * de banco de dados da entidade Livro.
 */
public interface LivroRepository extends JpaRepository<Livro, Long> {
    // O Spring Data JPA gera os métodos automaticamente
}