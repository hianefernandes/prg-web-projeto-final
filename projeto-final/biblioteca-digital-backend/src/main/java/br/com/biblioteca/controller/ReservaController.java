package br.com.biblioteca.controller;

// Importa a entidade Reserva
import br.com.biblioteca.entity.Reserva;
// Importa a camada de serviço responsável pelas regras de negócio da Reserva
import br.com.biblioteca.service.ReservaService;
// Importações do Spring
import org.springframework.web.bind.annotation.*;
// Importação da Lista
import java.util.List;

/**
 * Controller responsável por expor os endpoints
 * relacionados à reserva de livros.
 * 
 * A reserva permite que um usuário garanta um livro
 * quando não há exemplares disponíveis no momento.
 */
@RestController
@RequestMapping("/reservas")
@CrossOrigin
public class ReservaController {

    // Injeção da camada de serviço
    private final ReservaService service;

    /**
     * Construtor para injeção de dependência.
     */
    public ReservaController(ReservaService service) {
        this.service = service;
    }

    /**
     * Lista todas as reservas cadastradas.
     * 
     * Método HTTP: GET
     * URL: /reservas
     */
    @GetMapping
    public List<Reserva> listar() {
        return service.listar();
    }

    /**
     * Salva uma nova reserva.
     * 
     * Método HTTP: POST
     * URL: /reservas
     * 
     * @param reserva objeto enviado no corpo da requisição
     */
    @PostMapping
    public Reserva salvar(@RequestBody Reserva reserva) {
        return service.salvar(reserva);
    }

    /**
     * Remove uma reserva pelo ID.
     * 
     * Método HTTP: DELETE
     * URL: /reservas/{id}
     * 
     * @param id identificador da reserva
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}