// Define o pacote da camada Service
package br.com.biblioteca.service;

// Importa o DTO de Usuário
import br.com.biblioteca.dto.UsuarioDTO;
// Importa a entidade Usuario
import br.com.biblioteca.entity.Usuario;
// Importa exceção de regra de negócio
import br.com.biblioteca.exception.NegocioException;
// Importa o repositório de Usuário
import br.com.biblioteca.repository.UsuarioRepository;
// Importa a anotação Service
import org.springframework.stereotype.Service;

// Importa List
import java.util.List;

/**
 * Classe responsável pelas regras de negócio
 * relacionadas ao usuário.
 */
@Service
public class UsuarioService {

    // Repositório responsável pelas operações de usuário
    private final UsuarioRepository repository;

    // Injeção de dependência via construtor
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // Lista todos os usuários cadastrados
    public List<Usuario> listar() {
        return repository.findAll();
    }

    // Salva um usuário aplicando regras de negócio
    public Usuario salvar(UsuarioDTO dto) {

        // Regra de negócio: não permitir email duplicado
        if (repository.existsByEmail(dto.getEmail())) {
            throw new NegocioException("Já existe um usuário com este email");
        }

        // Converte DTO para Entity
        Usuario usuario = new Usuario(); // Cria uma nova entidade Usuario
        usuario.setNome(dto.getNome()); // Define o nome do usuário
        usuario.setEmail(dto.getEmail()); // Define o email do usuário
        usuario.setTipo(dto.getTipo()); // Define o tipo do usuário

        // Salva o usuário no banco
        return repository.save(usuario);
    }

    // Deleta um usuário pelo ID
    public void deletar(Long id) {

        // Verifica se o usuário existe
        if (!repository.existsById(id)) {
            throw new NegocioException("Usuário não encontrado");
        }

        // Remove o usuário do banco
        repository.deleteById(id);
    }
}