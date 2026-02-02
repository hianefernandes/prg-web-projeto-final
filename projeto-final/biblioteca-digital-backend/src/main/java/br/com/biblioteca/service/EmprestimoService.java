// Define o pacote da camada Service
package br.com.biblioteca.service;

// Importa a entidade Emprestimo
import br.com.biblioteca.entity.Emprestimo;
// Importa exceção personalizada de regra de negócio
import br.com.biblioteca.exception.NegocioException;
// Importa o repositório de Emprestimo
import br.com.biblioteca.repository.EmprestimoRepository;
// Importa a anotação Service
import org.springframework.stereotype.Service;

// Importa List
import java.util.List;

/**
 * Classe responsável pelas regras de negócio
 * relacionadas ao empréstimo.
 */
@Service
public class EmprestimoService {

    // Repositório responsável pelo acesso ao banco
    private final EmprestimoRepository repository;

    // Injeção de dependência via construtor
    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }

    // Lista todos os empréstimos
    public List<Emprestimo> listar() {
        return repository.findAll();
    }

    // Salva um empréstimo aplicando VALIDAÇÕES
    public Emprestimo salvar(Emprestimo emprestimo) {

        // Validação: Verifica se o empréstimo é nulo
        if (emprestimo == null) {
            throw new NegocioException("Empréstimo não pode ser nulo.");
        }

        // Verifica se existe usuário associado
        if (emprestimo.getUsuario() == null) {
            throw new NegocioException("Empréstimo deve possuir um usuário.");
        }

        // Verifica se existe exemplar associado
        if (emprestimo.getExemplar() == null) {
            throw new NegocioException("Empréstimo deve possuir um exemplar.");
        }

        // Verifica se a data do empréstimo foi informada
        if (emprestimo.getDataEmprestimo() == null) {
            throw new NegocioException("Data do empréstimo é obrigatória.");
        }

        // Se passar por todas as validações, salva no banco
        return repository.save(emprestimo);
    }

    // Remove um empréstimo pelo ID
    public void deletar(Long id) {

        // Validação: verifica se o id é nulo, pois não pode ser nulo
        if (id == null) {
            throw new NegocioException("ID do empréstimo não pode ser nulo.");
        }

        // Remove o empréstimo do banco
        repository.deleteById(id);
    }
}