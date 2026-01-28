package br.com.biblioteca.controller;

// Importa a entidade Categoria
import br.com.biblioteca.entity.Categoria;
// Importa a camada de serviço da Categoria
import br.com.biblioteca.service.CategoriaService;
// Importações do Spring
import org.springframework.web.bind.annotation.*;
// Importa a Lista
import java.util.List;

/**
 * Controller responsável pelos endpoints
 * relacionados à entidade Categoria.
 */
@RestController
@RequestMapping("/categorias")
@CrossOrigin
public class CategoriaController {

    // Injeção do service de Categoria
    private final CategoriaService service;

    /**
     * Construtor para injeção de dependência
     */
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    /**
     * Lista todas as categorias cadastradas.
     * 
     * Método HTTP: GET
     * URL: /categorias
     */
    @GetMapping
    public List<Categoria> listar() {
        return service.listar();
    }

    /**
     * Salva uma nova categoria.
     * 
     * Método HTTP: POST
     * URL: /categorias
     * 
     * "@ param" categoria objeto recebido do frontend
     */
    @PostMapping
    public Categoria salvar(@RequestBody Categoria categoria) {
        return service.salvar(categoria);
    }

    /**
     * Remove uma categoria pelo ID.
     * 
     * Método HTTP: DELETE
     * URL: /categorias/{id}
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}