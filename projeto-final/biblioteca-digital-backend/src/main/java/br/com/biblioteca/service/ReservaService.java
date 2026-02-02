// Define o pacote da camada Service
package br.com.biblioteca.service;

// Importa a entidade Reserva
import br.com.biblioteca.entity.Reserva;
// Importa o repositório de Reserva
import br.com.biblioteca.repository.ReservaRepository;
// Importa a anotação Service
import org.springframework.stereotype.Service;

// Importa List
import java.util.List;

// Indica que essa classe é um Service
@Service
public class ReservaService {

    // Repositório responsável pelas reservas
    private final ReservaRepository repository;

    // Injeção de dependência pelo construtor
    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    // Lista todas as reservas
    public List<Reserva> listar() {
        return repository.findAll();
    }

    // Salva uma reserva
    public Reserva salvar(Reserva reserva) {
        return repository.save(reserva);
    }

    // Remove uma reserva pelo ID
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}