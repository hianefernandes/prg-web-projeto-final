package br.com.biblioteca.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO responsável por transportar os dados do usuário
 * e aplicar validações antes de chegar no Service
 */
@Getter
@Setter
public class UsuarioDTO {

    // ID pode ser nulo no cadastro (POST)
    private Long id;

    // Nome não pode ser nulo nem vazio
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    // Email obrigatório e em formato válido
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    // Tipo do usuário (ex: ADMIN, ALUNO, FUNCIONARIO)
    @NotNull(message = "O tipo do usuário é obrigatório")
    private String tipo;
}