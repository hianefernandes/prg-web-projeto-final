package br.com.biblioteca.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO responsável por transportar os dados de empréstimo
 * entre o frontend e o backend.
 * 
 * Ele evita expor diretamente a entidade Emprestimo
 * e permite validações de entrada.
 */
@Getter
@Setter
public class EmprestimoDTO {

    // Identificador do empréstimo
    private Long id;

    // ID do usuário que está realizando o empréstimo
    // Não pode ser nulo
    @NotNull(message = "O usuário é obrigatório.")
    private Long usuarioId;

    // ID do exemplar que será emprestado
    // Não pode ser nulo
    @NotNull(message = "O exemplar é obrigatório.")
    private Long exemplarId;

    // Data em que o empréstimo foi realizado
    // Não pode ser nula
    @NotNull(message = "A data do empréstimo é obrigatória.")
    private LocalDate dataEmprestimo;

    // Data de devolução (pode ser nula no momento do empréstimo)
    private LocalDate dataDevolucao;
}