// Define o pacote da camada Repository
package br.com.biblioteca.repository;

// Importa a entidade Usuario
// Representa a tabela "usuarios" no banco de dados
import br.com.biblioteca.entity.Usuario;
// Importa a interface JpaRepository
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository responsável pelo acesso aos dados de Usuário.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Método que verifica se já existe um usuário com o email informado.
     * 
     * O Spring Data JPA interpreta o nome do método
     * e cria automaticamente a query no banco.
     *
     * @param email email a ser verificado
     * @return true se já existir, false caso contrário
     */
    boolean existsByEmail(String email);
}