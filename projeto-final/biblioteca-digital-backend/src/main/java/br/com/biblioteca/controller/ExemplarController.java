package br.com.biblioteca.controller;

// Importa a entidade Exemplar
import br.com.biblioteca.entity.Exemplar;
// Importa a camada de serviço responsável pelas regras de negócio do Exemplar
import br.com.biblioteca.service.ExemplarService;
// Importações necessárias para criação de controllers REST
import org.springframework.web.bind.annotation.*;
// Importação da Lista
import java.util.List;

/**
 * Controller responsável por expor os endpoints
 * relacionados à entidade Exemplar.
 * 
 * O Exemplar representa a unidade física de um livro,
 * permitindo controlar disponibilidade, empréstimos e reservas.
 */
@RestController // Define a classe como um controller REST
@RequestMapping("/exemplares") // Rota base da API para exemplares
@CrossOrigin // Permite acesso da API por aplicações externas (ex: frontend)
public class ExemplarController {

    // Injeção da camada de serviço
    private final ExemplarService service;

    /**
     * Construtor utilizado para injeção de dependência.
     * O Spring injeta automaticamente o ExemplarService.
     */
    public ExemplarController(ExemplarService service) {
        this.service = service;
    }

    /**
     * Endpoint responsável por listar todos os exemplares cadastrados.
     * 
     * Método HTTP: GET
     * URL: /exemplares
     * 
     * @return lista de exemplares
     */
    @GetMapping
    public List<Exemplar> listar() {
        return service.listar();
    }

    /**
     * Endpoint responsável por salvar um novo exemplar.
     * 
     * Método HTTP: POST
     * URL: /exemplares
     * 
     * @param exemplar objeto Exemplar enviado no corpo da requisição (JSON)
     * @return exemplar salvo no banco de dados
     */
    @PostMapping
    public Exemplar salvar(@RequestBody Exemplar exemplar) {
        return service.salvar(exemplar);
    }
    
    /**
     * Endpoint responsável por deletar um exemplar pelo ID.
     * 
     * Método HTTP: DELETE
     * URL: /exemplares/{id}
     * 
     * @param id identificador do exemplar a ser removido
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}