// Define o pacote repository
package br.com.biblioteca.repository;

// Importa a entidade Emprestimo
// Representa a tabela "emprestimos" no banco de dados
import br.com.biblioteca.entity.Emprestimo;
// Importa o JpaRepository do Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository responsável pelo acesso aos dados
 * relacionados aos empréstimos.
 */
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    // Métodos CRUD já são fornecidos automaticamente
}