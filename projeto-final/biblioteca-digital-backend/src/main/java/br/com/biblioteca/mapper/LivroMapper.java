// Permite que o Spring gerencie essa classe
import org.springframework.stereotype.Component;

// Importa o DTO de Livro
// Usado para comunicação entre a API e o sistema
import br.com.biblioteca.dto.LivroDTO;
// Importa a entidade Autor
import br.com.biblioteca.entity.Autor;
// Importa a entidade Categoria
import br.com.biblioteca.entity.Categoria;
// Importa a entidade Lvro
import br.com.biblioteca.entity.Livro;

/**
 * Mapper da entidade Livro.
 */
@Component // Permite injeção com @Autowired
public class LivroMapper {

    /**
     * Converte LivroDTO em entidade Livro
     */
    public Livro toEntity(LivroDTO dto, Autor autor, Categoria categoria) {
        Livro livro = new Livro(); // Cria um novo livro
        livro.setId(dto.getId()); // Define o ID
        livro.setTitulo(dto.getTitulo()); // Define o título
        livro.setAutor(autor); // Associa o autor
        livro.setCategoria(categoria); // Associa a categoria
        return livro; // Retorna a entidade
    }

    /**
     * Converte entidade Livro para DTO
     */
    public LivroDTO toDTO(Livro livro) {
        LivroDTO dto = new LivroDTO(); // Cria um novo DTO
        dto.setId(livro.getId()); // Define o ID
        dto.setTitulo(livro.getTitulo()); // Define o título
        dto.setAutorId(livro.getAutor().getId()); // Define o ID do autor
        dto.setCategoriaId(livro.getCategoria().getId()); // Define o ID da categoria
        return dto; // Retorna o DTO
    }
}