package br.com.biblioteca.controller;

import br.com.biblioteca.entity.Reserva;
import br.com.biblioteca.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reserva> listar() {
        return service.listar();
    }

    @PostMapping
    public Reserva salvar(@RequestBody Reserva reserva) {
        return service.salvar(reserva);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}