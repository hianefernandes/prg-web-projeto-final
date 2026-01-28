package br.com.biblioteca.controller;

// Importa a entidade Autor, que representa a tabela Autor no banco de dados
import br.com.biblioteca.entity.Autor;
// Importa a camada de serviço responsável pelas regras de negócio do Autor
import br.com.biblioteca.service.AutorService;
// Importações do Spring para criação de APIs REST
import org.springframework.web.bind.annotation.*;
// Importa a funcionalidade de Lista
import java.util.List;

/**
 * Controller responsável por expor os endpoints
 * relacionados à entidade Autor.
 * 
 * Essa classe recebe as requisições HTTP do frontend
 * e repassa as chamadas para a camada de serviço.
 */
@RestController  // Indica que esta classe é um controller REST
@RequestMapping("/autores")  // Define a rota base da API: /autores
@CrossOrigin  // Permite requisições de outros domínios (ex: frontend em outra porta)
public class AutorController {

    // Injeção da camada de serviço
    private final AutorService service;

    /**
     * Construtor utilizado para injeção de dependência.
     * O Spring injeta automaticamente o AutorService.
     */
    public AutorController(AutorService service) {
        this.service = service;
    }

    /**
     * Endpoint responsável por listar todos os autores cadastrados.
     * 
     * Método HTTP: GET
     * URL: /autores
     * 
     * "@ return" lista de autores
     */
    @GetMapping
    public List<Autor> listar() {
        return service.listar();
    }

    /**
     * Endpoint responsável por salvar um novo autor.
     * 
     * Método HTTP: POST
     * URL: /autores
     * 
     * "@ param" autor   objeto Autor enviado no corpo da requisição (JSON)
     * "@ return" autor  salvo no banco de dados
     */
    @PostMapping
    public Autor salvar(@RequestBody Autor autor) {
        return service.salvar(autor);
    }

    /**
     * Endpoint responsável por deletar um autor pelo ID.
     * 
     * Método HTTP: DELETE
     * URL: /autores/{id}
     * 
     * "@ param" id identificador do autor a ser removido
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}