// Importa a anotação @Service do Spring
import org.springframework.stereotype.Service;

// Importa o DTO de Avaliação
import br.com.biblioteca.dto.AvaliacaoDTO;
// Importa a entidade Avaliacao
import br.com.biblioteca.entity.Avaliacao;
// Importa a entidade Livro
import br.com.biblioteca.entity.Livro;
// Importa a entidade Usuario
import br.com.biblioteca.entity.Usuario;
// Importa o Mapper responsável por converter
import br.com.biblioteca.mapper.AvaliacaoMapper;
// Importa o repositório de Avaliação
import br.com.biblioteca.repository.AvaliacaoRepository;
// Importa o repositório de Livro
import br.com.biblioteca.repository.LivroRepository;
// Importa o repositório de Usuário
import br.com.biblioteca.repository.UsuarioRepository;
// Importa a anotação do Lombok que gera automaticamente
// um construtor com todos os atributos final da classe
import lombok.RequiredArgsConstructor;

// Indica que essa classe é um Service do Spring
@Service
// Lombok cria automaticamente o construtor com os atributos finais
@RequiredArgsConstructor
public class AvaliacaoService {

    // Repositório de Avaliação
    private final AvaliacaoRepository repository;
    // Repositório de Usuário
    private final UsuarioRepository usuarioRepository;
    // Repositório de Livro
    private final LivroRepository livroRepository;
    // Mapper responsável por converter Entity ↔ DTO
    private final AvaliacaoMapper mapper;

    // Método responsável por salvar uma avaliação
    public AvaliacaoDTO salvar(AvaliacaoDTO dto) {
        // Busca o usuário pelo ID informado no DTO
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
            // Caso não encontre, lança exceção
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Busca o livro pelo ID informado no DTO
        Livro livro = livroRepository.findById(dto.getLivroId())
            // Caso não encontre, lança exceção
            .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        // Converte o DTO para entidade Avaliacao
        Avaliacao avaliacao = mapper.toEntity(dto, usuario, livro);
        // Salva a avaliação no banco e converte de volta para DTO
        return mapper.toDTO(repository.save(avaliacao));
    }

    // Método responsável por listar todas as avaliações
    public List<AvaliacaoDTO> listar() {
        // Busca todas as avaliações no banco
        return repository.findAll().stream()
            // Converte cada entidade para DTO
            .map(mapper::toDTO)
            // Converte o stream em lista
            .toList();
    }

    // Método responsável por deletar uma avaliação pelo ID
    public void deletar(Long id) {
        // Remove a avaliação do banco de dados
        repository.deleteById(id);
    }
}