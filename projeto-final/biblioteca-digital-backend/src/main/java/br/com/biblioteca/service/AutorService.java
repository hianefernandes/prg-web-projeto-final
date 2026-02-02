// Define o pacote da camada de Service
package br.com.biblioteca.service;

// Importa a entidade Autor
// Representa a tabela "autores" no banco de dados
import br.com.biblioteca.entity.Autor;
// Importa o repositório de Autor
// Responsável pelo acesso ao banco de dados
import br.com.biblioteca.repository.AutorRepository;
// Importa a anotação Service do Spring
// Indica que essa classe contém regras de negócio
import org.springframework.stereotype.Service;

// Importa a interface List
// Usada para trabalhar com listas de autores
import java.util.List;

// Indica que essa classe é um Service gerenciado pelo Spring
@Service
public class AutorService {

    // Repositório responsável pelas operações de Autor no banco
    private final AutorRepository repository;

    // Injeção de dependência via construtor
    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    // Método responsável por listar todos os autores cadastrados
    public List<Autor> listar() {
        // Busca todos os autores no banco de dados
        return repository.findAll();
    }

    // Método responsável por salvar um novo autor
    public Autor salvar(Autor autor) {
        // Salva o autor no banco e retorna o objeto persistido
        return repository.save(autor);
    }

    // Método responsável por deletar um autor pelo ID
    public void deletar(Long id) {
        // Remove o autor do banco de dados pelo ID
        repository.deleteById(id);
    }
}