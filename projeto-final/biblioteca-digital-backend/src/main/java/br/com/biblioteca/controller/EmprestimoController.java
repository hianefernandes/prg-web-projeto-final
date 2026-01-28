package br.com.biblioteca.controller;

import br.com.biblioteca.dto.EmprestimoDTO;
import br.com.biblioteca.entity.Emprestimo;
import br.com.biblioteca.exception.NegocioException;
import br.com.biblioteca.service.EmprestimoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por expor os endpoints
 * relacionados ao empréstimo de livros.
 * 
 * Aqui ficam apenas as chamadas HTTP,
 * enquanto as regras de negócio ficam no Service.
 */
@RestController
@RequestMapping("/emprestimos")
@CrossOrigin
public class EmprestimoController {

    // Camada de serviço responsável pelas regras de negócio
    private final EmprestimoService service;

    // Injeção de dependência via construtor
    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    /**
     * Endpoint para listar todos os empréstimos cadastrados
     *
     * @return lista de empréstimos
     */
    @GetMapping
    public List<Emprestimo> listar() {
        return service.listar();
    }

    /**
     * Salva um novo empréstimo utilizando DTO e validações.
     * 
     * @Valid ativa as validações definidas no DTO.
     * 
     * Caso alguma regra de negócio seja violada,
     * retorna uma mensagem de erro.
     */
    @PostMapping
    public ResponseEntity<?> salvar(@Valid @RequestBody EmprestimoDTO dto) {
        try {
            // Chama o service que aplica regras de negócio
            return ResponseEntity.ok(service.salvarDTO(dto));
        } catch (NegocioException e) {
            // Retorna erro de regra de negócio
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    /**
     * Deleta um empréstimo pelo ID.
     * 
     * Caso o empréstimo não possa ser removido
     * devido a alguma regra de negócio,
     * uma mensagem de erro será retornada.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.ok().build();
        } catch (NegocioException e) {
            // Retorna erro caso alguma regra de negócio seja violada
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}