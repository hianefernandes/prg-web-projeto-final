package br.com.biblioteca.repository;

import br.com.biblioteca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository responsável pelo acesso aos dados de Usuário
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Verifica se já existe um usuário com o email informado
     * O Spring Data JPA cria essa query automaticamente
     */
    boolean existsByEmail(String email);
}