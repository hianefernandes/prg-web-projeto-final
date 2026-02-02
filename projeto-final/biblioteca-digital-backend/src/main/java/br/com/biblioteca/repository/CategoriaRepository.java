// Define o pacote da camada Repository
package br.com.biblioteca.repository;

// Importa a entidade Categoria
// Representa a tabela "categorias" no banco
import br.com.biblioteca.entity.Categoria;
// Importa o JpaRepository
// Interface base para acesso ao banco de dados
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository responsável por realizar operações
 * de persistência da entidade Categoria.
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Nenhum método extra é necessário no momento
}
