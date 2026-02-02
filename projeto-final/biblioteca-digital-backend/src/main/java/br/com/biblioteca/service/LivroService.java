// Define o pacote da camada Service
package br.com.biblioteca.service;

// Importa a entidade Livro
import br.com.biblioteca.entity.Livro;
// Importa o repositório de Livro
import br.com.biblioteca.repository.LivroRepository;
// Importa a anotação Service
import org.springframework.stereotype.Service;

// Importa List
import java.util.List;

// Indica que essa classe é um serviço do Spring
@Service
public class LivroService {

    // Repositório responsável pelas operações de Livro
    private final LivroRepository repository;

    // Injeção de dependência via construtor
    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    // Lista todos os livros cadastrados
    public List<Livro> listar() {
        return repository.findAll();
    }

    // Salva um livro
    public Livro salvar(Livro livro) {
        return repository.save(livro);
    }

    // Remove um livro pelo ID
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}