// Define o pacote da camada Service
package br.com.biblioteca.service;

// Importa a entidade Exemplar
import br.com.biblioteca.entity.Exemplar;
// Importa o repositório de Exemplar
import br.com.biblioteca.repository.ExemplarRepository;
// Importa a anotação Service
import org.springframework.stereotype.Service;

// Importa List
import java.util.List;

// Indica que essa classe é um Service do Spring
@Service
public class ExemplarService {

    // Repositório responsável pelas operações de Exemplar
    private final ExemplarRepository repository;

    // Injeção de dependência pelo construtor
    public ExemplarService(ExemplarRepository repository) {
        this.repository = repository;
    }

    // Lista todos os exemplares
    public List<Exemplar> listar() {
        return repository.findAll();
    }

    // Salva um exemplar
    public Exemplar salvar(Exemplar exemplar) {
        return repository.save(exemplar);
    }

    // Deleta um exemplar pelo ID
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}