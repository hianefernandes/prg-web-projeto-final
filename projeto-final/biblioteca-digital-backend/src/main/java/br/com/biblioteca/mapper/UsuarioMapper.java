// Define o pacote da classe
package br.com.biblioteca.mapper;

// Importa o DTO de Usuário
import br.com.biblioteca.dto.UsuarioDTO;
// Importa a entidade Usuario
import br.com.biblioteca.entity.Usuario;

/**
 * Mapper responsável pela conversão
 * Usuario ↔ UsuarioDTO
 */
public class UsuarioMapper {

    /**
     * Converte entidade Usuario para DTO
     */
    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO(); // Cria um novo DTO
        dto.setId(usuario.getId()); // Define o ID
        dto.setNome(usuario.getNome()); // Define o nome
        dto.setEmail(usuario.getEmail()); // Define o email
        dto.setTipo(usuario.getTipo()); // Define o tipo do usuário
        return dto; // Retorna o DTO
    }

    /**
     * Converte UsuarioDTO para entidade Usuario
     */
    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario(); // Cria uma nova entidade Usuario
        usuario.setId(dto.getId()); // Define o ID
        usuario.setNome(dto.getNome()); // Define o nome
        usuario.setEmail(dto.getEmail()); // Define o email
        usuario.setTipo(dto.getTipo()); // Define o tipo do usuário
        return usuario; // Retorna a entidade
    }
}