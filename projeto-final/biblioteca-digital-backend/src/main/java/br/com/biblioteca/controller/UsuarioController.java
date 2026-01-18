package br.com.biblioteca.controller;

import br.com.biblioteca.dto.UsuarioDTO;
import br.com.biblioteca.entity.Usuario;
import br.com.biblioteca.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por expor os endpoints
 * relacionados ao usuário
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    /**
     * Endpoint para listar usuários
     */
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    /**
     * Endpoint para salvar usuário
     * @Valid ativa as validações do DTO
     */
    @PostMapping
    public Usuario salvar(@RequestBody @Valid UsuarioDTO dto) {
        return service.salvar(dto);
    }

    /**
     * Endpoint para deletar usuário
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}