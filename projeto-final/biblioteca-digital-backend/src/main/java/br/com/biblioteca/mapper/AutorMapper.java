// Define o pacote onde ficam as entidades do sistema.
package br.com.biblioteca.mapper;

// Importa o DTO de Autor (objeto usado para troca de dados com a API)
import br.com.biblioteca.dto.AutorDTO;
// Importa a entidade Autor (representa a tabela no banco)
import br.com.biblioteca.entity.Autor;

/**
 * Classe responsável por converter objetos Autor
 * entre Entity (banco de dados) e DTO (camada de API).
 */
public class AutorMapper {

    /**
     * Converte uma entidade Autor em um AutorDTO
     *
     * @param autor entidade vinda do banco de dados
     * @return objeto DTO para resposta da API
     */
    public static AutorDTO toDTO(Autor autor) {
        AutorDTO dto = new AutorDTO(); // Cria um novo DTO
        dto.setId(autor.getId()); // Copia o ID da entidade para o DTO
        dto.setNome(autor.getNome()); // Copia o nome do autor
        dto.setNacionalidade(autor.getNacionalidade()); // Copia a nacionalidade do autor
        return dto; // Retorna o DTO preenchido
    }

    /**
     * Converte um AutorDTO em uma entidade Autor
     *
     * @param dto objeto recebido da API
     * @return entidade pronta para persistência no banco
     */
    public static Autor toEntity(AutorDTO dto) {
        Autor autor = new Autor(); // Cria uma nova entidade Autor
        autor.setId(dto.getId()); // Define o ID (usado principalmente em atualizações)
        autor.setNome(dto.getNome()); // Define o nome do autor
        autor.setNacionalidade(dto.getNacionalidade()); // Define a nacionalidade
        return autor; // Retorna a entidade preenchida
    }
}