// Define o pacote da camada Repository
package br.com.biblioteca.repository;

// Importa a entidade Exemplar
// Representa a tabela "exemplares" no banco de dados
import br.com.biblioteca.entity.Exemplar;
// Importa a interface JpaRepository
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository responsável pelo acesso aos dados
 * da entidade Exemplar.
 */
public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {
    // Nenhuma implementação manual é necessária
}