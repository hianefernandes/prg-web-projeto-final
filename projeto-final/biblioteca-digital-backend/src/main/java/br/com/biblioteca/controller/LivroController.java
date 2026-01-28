package br.com.biblioteca.controller;

// Importa a entidade Livro
import br.com.biblioteca.entity.Livro;
// Importa a camada de serviço do Livro
import br.com.biblioteca.service.LivroService;
// Importações do Spring para criação de endpoints REST
import org.springframework.web.bind.annotation.*;
// Importação da Lista
import java.util.List;

/**
 * Controller responsável por expor os endpoints
 * relacionados à entidade Livro.
 * 
 * O Livro contém informações como título, autor,
 * categoria e demais dados bibliográficos.
 */
@RestController // Indica que a classe é um controller REST
@RequestMapping("/livros") // Rota base da API
@CrossOrigin // Libera requisições de outros domínios
public class LivroController {

    // Injeção do serviço de Livro
    private final LivroService service;

    /**
     * Construtor para injeção de dependência.
     */
    public LivroController(LivroService service) {
        this.service = service;
    }

    /**
     * Endpoint para listar todos os livros cadastrados.
     * 
     * Método HTTP: GET
     * URL: /livros
     * 
     * @return lista de livros
     */
    @GetMapping
    public List<Livro> listar() {
        return service.listar();
    }

     /**
     * Endpoint para salvar um novo livro.
     * 
     * Método HTTP: POST
     * URL: /livros
     * 
     * @param livro objeto recebido do frontend
     * @return livro salvo no banco de dados
     */
    @PostMapping
    public Livro salvar(@RequestBody Livro livro) {
        return service.salvar(livro);
    }

    /**
     * Endpoint responsável por deletar um livro pelo ID.
     * 
     * Método HTTP: DELETE
     * URL: /livros/{id}
     * 
     * @param id identificador do livro
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}