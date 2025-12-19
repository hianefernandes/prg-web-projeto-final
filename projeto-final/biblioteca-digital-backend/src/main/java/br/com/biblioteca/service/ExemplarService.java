package br.com.biblioteca.service;

import br.com.biblioteca.entity.Exemplar;
import br.com.biblioteca.repository.ExemplarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExemplarService {

    private final ExemplarRepository repository;

    public ExemplarService(ExemplarRepository repository) {
        this.repository = repository;
    }

    public List<Exemplar> listar() {
        return repository.findAll();
    }

    public Exemplar salvar(Exemplar exemplar) {
        return repository.save(exemplar);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}