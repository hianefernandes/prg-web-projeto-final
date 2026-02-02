// Importa a interface JpaRepository do Spring Data JPA
// Responsável por fornecer operações CRUD prontas
import org.springframework.data.jpa.repository.JpaRepository;

// Importa a entidade Avaliacao
// Representa a tabela "avaliacoes" no banco de dados
import br.com.biblioteca.entity.Avaliacao;

/**
 * Repository responsável pelo acesso aos dados da entidade Avaliacao.
 */
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    // O Spring cria automaticamente as operações básicas de banco
}