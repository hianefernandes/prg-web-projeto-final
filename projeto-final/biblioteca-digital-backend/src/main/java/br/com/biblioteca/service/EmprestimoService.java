package br.com.biblioteca.service;

import br.com.biblioteca.entity.Emprestimo;
import br.com.biblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository repository;

    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }

    public List<Emprestimo> listar() {
        return repository.findAll();
    }

    public Emprestimo salvar(Emprestimo emprestimo) {
        return repository.save(emprestimo);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}