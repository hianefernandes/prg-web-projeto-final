package br.com.biblioteca.service;

import br.com.biblioteca.entity.Autor;
import br.com.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public List<Autor> listar() {
        return repository.findAll();
    }

    public Autor salvar(Autor autor) {
        return repository.save(autor);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}