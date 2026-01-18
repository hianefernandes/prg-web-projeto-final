package br.com.biblioteca.service;

import br.com.biblioteca.dto.UsuarioDTO;
import br.com.biblioteca.entity.Usuario;
import br.com.biblioteca.exception.NegocioException;
import br.com.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsável pelas regras de negócio
 * relacionadas ao usuário
 */
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    /**
     * Lista todos os usuários
     */
    public List<Usuario> listar() {
        return repository.findAll();
    }

    /**
     * Salva um usuário aplicando regras de negócio
     */
    public Usuario salvar(UsuarioDTO dto) {

        // Exemplo de regra de negócio:
        // não permitir email duplicado
        if (repository.existsByEmail(dto.getEmail())) {
            throw new NegocioException("Já existe um usuário com este email");
        }

        // Converte DTO para Entity
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setTipo(dto.getTipo());

        // Salva no banco
        return repository.save(usuario);
    }

    /**
     * Deleta um usuário pelo ID
     */
    public void deletar(Long id) {

        // Verifica se o usuário existe
        if (!repository.existsById(id)) {
            throw new NegocioException("Usuário não encontrado");
        }

        repository.deleteById(id);
    }
}