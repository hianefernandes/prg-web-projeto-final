// Define o pacote onde a interface Repository está localizada
package br.com.biblioteca.repository;

// Importa a entidade Autor
// Essa entidade representa a tabela "autores" no banco de dados
import br.com.biblioteca.entity.Autor;
// Importa a interface JpaRepository do Spring Data JPA
// Ela fornece automaticamente métodos CRUD prontos
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository responsável pelo acesso aos dados da entidade Autor.
 * 
 * Ao estender JpaRepository, essa interface herda métodos como:
 * - save()
 * - findById()
 * - findAll()
 * - deleteById()
 */
public interface AutorRepository extends JpaRepository<Autor, Long> {
    // Não é necessário escrever código aqui,
    // pois o Spring Data JPA gera tudo automaticamente
}