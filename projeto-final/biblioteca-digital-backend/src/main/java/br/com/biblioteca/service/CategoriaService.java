// Define o pacote da camada Service
package br.com.biblioteca.service;

// Importa a entidade Categoria
import br.com.biblioteca.entity.Categoria;
// Importa o repositório de Categoria
import br.com.biblioteca.repository.CategoriaRepository;
// Importa a anotação Service
import org.springframework.stereotype.Service;

// Importa List
import java.util.List;

// Indica que essa classe é um serviço do Spring
@Service
public class CategoriaService {

    // Repositório responsável pelas operações de Categoria
    private final CategoriaRepository repository;

    // Injeção de dependência via construtor
    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    // Lista todas as categorias
    public List<Categoria> listar() {
        return repository.findAll();
    }

    // Salva uma nova categoria
    public Categoria salvar(Categoria categoria) {
        return repository.save(categoria);
    }

    // Remove uma categoria pelo ID
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}