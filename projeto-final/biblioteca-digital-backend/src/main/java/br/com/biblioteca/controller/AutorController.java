package br.com.biblioteca.controller;

import br.com.biblioteca.entity.Autor;
import br.com.biblioteca.service.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
@CrossOrigin
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Autor> listar() {
        return service.listar();
    }

    @PostMapping
    public Autor salvar(@RequestBody Autor autor) {
        return service.salvar(autor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}