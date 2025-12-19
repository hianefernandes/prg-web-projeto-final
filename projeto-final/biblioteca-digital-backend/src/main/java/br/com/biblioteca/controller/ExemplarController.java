package br.com.biblioteca.controller;

import br.com.biblioteca.entity.Exemplar;
import br.com.biblioteca.service.ExemplarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exemplares")
@CrossOrigin
public class ExemplarController {

    private final ExemplarService service;

    public ExemplarController(ExemplarService service) {
        this.service = service;
    }

    @GetMapping
    public List<Exemplar> listar() {
        return service.listar();
    }

    @PostMapping
    public Exemplar salvar(@RequestBody Exemplar exemplar) {
        return service.salvar(exemplar);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}