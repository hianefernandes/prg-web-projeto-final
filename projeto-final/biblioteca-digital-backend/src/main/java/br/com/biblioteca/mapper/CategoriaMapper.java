// Define o pacote onde a classe está localizada
package br.com.biblioteca.mapper;

// Importa o DTO de Categoria
// Usado para transportar dados entre API e sistema
import br.com.biblioteca.dto.CategoriaDTO;
// Importa a entidade Categoria
// Representa a tabela "categorias" no banco de dados
import br.com.biblioteca.entity.Categoria;

/**
 * Classe responsável por converter
 * Categoria (Entity) ↔ CategoriaDTO
 */
public class CategoriaMapper {

    /**
     * Converte uma entidade Categoria em um DTO
     *
     * @param categoria entidade vinda do banco
     * @return DTO para resposta da API
     */
    public static CategoriaDTO toDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO(); // Cria um novo objeto DTO
        dto.setId(categoria.getId()); // Copia o ID da entidade para o DTO
        dto.setNome(categoria.getNome()); // Copia o nome da categoria
        dto.setDescricao(categoria.getDescricao()); // Copia a descrição da categoria
        return dto; // Retorna o DTO preenchido
    }

    /**
     * Converte um DTO em entidade Categoria
     *
     * @param dto dados recebidos da API
     * @return entidade pronta para persistência
     */
    public static Categoria toEntity(CategoriaDTO dto) {
        Categoria categoria = new Categoria(); // Cria uma nova entidade Categoria
        categoria.setId(dto.getId()); // Define o ID (importante em atualizações)
        categoria.setNome(dto.getNome()); // Define o nome da categoria
        categoria.setDescricao(dto.getDescricao()); // Define a descrição da categoria
        return categoria; // Retorna a entidade preenchida
    }
}