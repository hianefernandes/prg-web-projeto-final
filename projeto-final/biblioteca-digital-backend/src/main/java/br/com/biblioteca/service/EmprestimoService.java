package br.com.biblioteca.service;

import br.com.biblioteca.entity.Emprestimo;
import br.com.biblioteca.exception.NegocioException;
import br.com.biblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de serviço responsável pelas regras de negócio
 * relacionadas ao empréstimo.
 */
@Service
public class EmprestimoService {

    // Repositório responsável pelo acesso ao banco de dados
    private final EmprestimoRepository repository;

    // Injeção de dependência pelo construtor
    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }

    /**
     * Lista todos os empréstimos cadastrados
     * @return lista de empréstimos
     */
    public List<Emprestimo> listar() {
        return repository.findAll();
    }

    /**
     * Salva um novo empréstimo aplicando validações
     * e regras de negócio.
     * 
     * @param emprestimo objeto empréstimo recebido
     * @return empréstimo salvo
     */
    public Emprestimo salvar(Emprestimo emprestimo) {

        // Validação: empréstimo não pode ser nulo
        if (emprestimo == null) {
            throw new NegocioException("Empréstimo não pode ser nulo.");
        }

        // Regra de negócio: empréstimo precisa ter usuário
        if (emprestimo.getUsuario() == null) {
            throw new NegocioException("Empréstimo deve possuir um usuário.");
        }

        // Regra de negócio: empréstimo precisa ter exemplar
        if (emprestimo.getExemplar() == null) {
            throw new NegocioException("Empréstimo deve possuir um exemplar.");
        }

        // Regra de negócio: data do empréstimo é obrigatória
        if (emprestimo.getDataEmprestimo() == null) {
            throw new NegocioException("Data do empréstimo é obrigatória.");
        }

        // Se passar por todas as validações, salva no banco
        return repository.save(emprestimo);
    }

    /**
     * Remove um empréstimo pelo ID
     * 
     * @param id identificador do empréstimo
     */
    public void deletar(Long id) {

        // Validação: ID não pode ser nulo
        if (id == null) {
            throw new NegocioException("ID do empréstimo não pode ser nulo.");
        }

        // Remove o empréstimo do banco
        repository.deleteById(id);
    }
}