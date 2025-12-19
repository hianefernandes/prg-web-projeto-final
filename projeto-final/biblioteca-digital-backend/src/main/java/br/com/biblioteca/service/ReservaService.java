package br.com.biblioteca.service;

import br.com.biblioteca.entity.Reserva;
import br.com.biblioteca.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public List<Reserva> listar() {
        return repository.findAll();
    }

    public Reserva salvar(Reserva reserva) {
        return repository.save(reserva);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}