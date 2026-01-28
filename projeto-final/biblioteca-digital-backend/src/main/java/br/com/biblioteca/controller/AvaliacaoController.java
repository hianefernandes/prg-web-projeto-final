import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.dto.AvaliacaoDTO;
import br.com.biblioteca.service.AvaliacaoService;
import lombok.RequiredArgsConstructor;

// Indica que esta classe é um controller REST
@RestController
// Define a rota base da API para avaliacoes
@RequestMapping("/avaliacoes")
// Gera automaticamente o constructor com argumentos finais (lombok)
@RequiredArgsConstructor
// Permite acesso da API por outros dominios
@CrossOrigin
public class AvaliacaoController {
    // Injeção da camada de serviço de Aavaliação
    private final AvaliacaoService service;
    
    /**
     * Endpoint responsável por criar uma nova avaliação.
     * 
     * Método HTTP: POST
     * URL: /avaliacoes
     * 
     * Utiliza DTO para transferência de dados,
     * evitando expor diretamente a entidade.
     * 
     * "@ param" dto dados da avaliação vindos do frontend
     * "@ return" avaliação salva
     */
    @PostMapping
    public AvaliacaoDTO criar(@RequestBody AvaliacaoDTO dto) {
        return service.salvar(dto);
    }

    /**
     * Endpoint responsável por listar todas as avaliações.
     * 
     * Método HTTP: GET
     * URL: /avaliacoes
     * 
     * "@ return" lista de avaliações em formato DTO
     */
    @GetMapping
    public List<AvaliacaoDTO> listar() {
        return service.listar();
    }

    /**
     * Endpoint responsável por deletar uma avaliação pelo ID.
     * 
     * Método HTTP: DELETE
     * URL: /avaliacoes/{id}
     * 
     * "@ param" id identificador da avaliação
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}