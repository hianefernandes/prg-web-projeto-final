// Permite injeção de dependência pelo Spring
import org.springframework.stereotype.Component;

// Importa o DTO de Exemplar
// Usado para receber e devolver dados do exemplar pela API
import br.com.biblioteca.dto.ExemplarDTO;
// Importa a entidade Exemplar
import br.com.biblioteca.entity.Exemplar;
// Importa a entidade Livro
import br.com.biblioteca.entity.Livro;

/**
 * Mapper da entidade Exemplar.
 */
@Component // Permite injeção com @Autowired
public class ExemplarMapper {

    /**
     * Converte ExemplarDTO para entidade Exemplar
     */
    public Exemplar toEntity(ExemplarDTO dto, Livro livro) {
        Exemplar exemplar = new Exemplar(); // Cria um novo exemplar
        exemplar.setId(dto.getId()); // Define o ID do exemplar
        exemplar.setCodigo(dto.getCodigo()); // Define o código do exemplar
        exemplar.setLivro(livro); // Associa o livro ao exemplar
        return exemplar; // Retorna a entidade
    }

    /**
     * Converte entidade Exemplar para DTO
     */
    public ExemplarDTO toDTO(Exemplar exemplar) {
        ExemplarDTO dto = new ExemplarDTO(); // Cria um novo DTO
        dto.setId(exemplar.getId()); // Define o ID
        dto.setCodigo(exemplar.getCodigo()); // Define o código
        dto.setLivroId(exemplar.getLivro().getId()); // Define o ID do livro associado
        return dto; // Retorna o DTO
    }
}