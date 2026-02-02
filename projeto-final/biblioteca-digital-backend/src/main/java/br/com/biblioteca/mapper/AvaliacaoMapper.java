// Permite que essa classe seja gerenciada pelo Spring
// Assim ela pode ser injetada com @Autowired
import org.springframework.stereotype.Component;

// Importa o DTO de Avaliação
// Usado para receber e devolver dados pela API
import br.com.biblioteca.dto.AvaliacaoDTO;
// Importa a entidade Avaliacao
// Representa a tabela "avaliacoes" no banco de dados
import br.com.biblioteca.entity.Avaliacao;
// Importa a entidade Livro
// Usada para associar a avaliação a um livro específico
import br.com.biblioteca.entity.Livro;
// Importa a entidade Usuario
// Usada para associar a avaliação a um usuário
import br.com.biblioteca.entity.Usuario;

/**
 * Mapper responsável por converter Avaliação
 * entre Entity e DTO.
 */
@Component // Permite injeção com @Autowired
public class AvaliacaoMapper {

    /**
     * Converte AvaliacaoDTO para entidade Avaliacao
     *
     * @param dto dados da avaliação vindos da API
     * @param usuario usuário já buscado no banco
     * @param livro livro já buscado no banco
     * @return entidade Avaliacao
     */
    public Avaliacao toEntity(AvaliacaoDTO dto, Usuario usuario, Livro livro) {
        Avaliacao avaliacao = new Avaliacao(); // Cria uma nova avaliação
        avaliacao.setId(dto.getId()); // Define o ID (útil em atualizações)
        avaliacao.setNota(dto.getNota()); // Define a nota da avaliação
        avaliacao.setComentario(dto.getComentario()); // Define o comentário da avaliação
        avaliacao.setUsuario(usuario); // Associa o usuário à avaliação
        avaliacao.setLivro(livro); // Associa o livro à avaliação
        return avaliacao; // Retorna a entidade pronta
    }

    /**
     * Converte entidade Avaliacao em AvaliacaoDTO
     *
     * @param avaliacao entidade vinda do banco
     * @return DTO para resposta da API
     */
    public AvaliacaoDTO toDTO(Avaliacao avaliacao) {
        AvaliacaoDTO dto = new AvaliacaoDTO(); // Cria um novo DTO
        dto.setId(avaliacao.getId()); // Define o ID da avaliação
        dto.setNota(avaliacao.getNota()); // Define a nota
        dto.setComentario(avaliacao.getComentario()); // Define o comentário
        dto.setUsuarioId(avaliacao.getUsuario().getId()); // Envia apenas o ID do usuário
        dto.setLivroId(avaliacao.getLivro().getId()); // Envia apenas o ID do livro
        return dto; // Retorna o DTO preenchido
    }
}