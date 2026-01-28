package br.com.biblioteca.controller;

// Importa o DTO utilizado para entrada de dados do usuário
import br.com.biblioteca.dto.UsuarioDTO;
// Importa a entidade Usuario
import br.com.biblioteca.entity.Usuario;
// Importa a camada de serviço do Usuário
import br.com.biblioteca.service.UsuarioService;
// Importação para validações
import jakarta.validation.Valid;
// Importações do Spring
import org.springframework.web.bind.annotation.*;
// Importação da Lista
import java.util.List;

/**
 * Controller responsável por expor os endpoints
 * relacionados à entidade Usuário.
 * 
 * O uso de DTO evita expor diretamente a entidade
 * e permite aplicar validações de forma segura.
 */
@RestController // Indica que esta classe é um controller REST
@RequestMapping("/usuarios") // Define a rota base da API
@CrossOrigin // Permite requisições de outros domínios (ex: frontend em outra porta)
public class UsuarioController {

    // Injeção da camada de serviço
    private final UsuarioService service;

    /**
     * Construtor para injeção de dependência.
     */
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    /**
     * Endpoint para listar todos os usuários cadastrados.
     * 
     * Método HTTP: GET
     * URL: /usuarios
     * 
     * @return lista de usuários
     */
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    /**
     * Endpoint para salvar um novo usuário.
     * 
     * @Valid ativa as validações definidas no DTO,
     * como campos obrigatórios e formatos corretos.
     * 
     * Método HTTP: POST
     * URL: /usuarios
     * 
     * @param dto dados do usuário vindos do frontend
     * @return usuário salvo
     */
    @PostMapping
    public Usuario salvar(@RequestBody @Valid UsuarioDTO dto) {
        return service.salvar(dto);
    }

    /**
     * Endpoint responsável por deletar um usuário pelo ID.
     * 
     * Método HTTP: DELETE
     * URL: /usuarios/{id}
     * 
     * @param id identificador do usuário
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}