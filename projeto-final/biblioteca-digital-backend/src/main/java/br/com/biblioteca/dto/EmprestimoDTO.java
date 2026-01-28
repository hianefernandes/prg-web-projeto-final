// Define o pacote do DTO de Empréstimo
package br.com.biblioteca.dto;

// Importa anotação para validação de campos obrigatórios
import jakarta.validation.constraints.NotNull;
// Importa Lombok para gerar getters automaticamente
import lombok.Getter;
// Importa Lombok para gerar setters automaticamente
import lombok.Setter;

// Importa a classe LocalDate para trabalhar com datas
import java.time.LocalDate;

/**
 * DTO responsável por transportar os dados de empréstimo
 * entre o frontend e o backend.
 * 
 * Ele evita expor diretamente a entidade Emprestimo
 * e permite validações de entrada.
 */
@Getter // Gera os métodos getters
@Setter // Gera os métodos setters

// DTO responsável por transportar dados do empréstimo
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