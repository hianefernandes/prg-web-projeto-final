// Define o pacote do DTO de Usuário
package br.com.biblioteca.dto;

// Importa validação para formato de email
import jakarta.validation.constraints.Email;
// Importa validação para campos obrigatórios e não vazios
import jakarta.validation.constraints.NotBlank;
// Importa validação para campos obrigatórios
import jakarta.validation.constraints.NotNull;
// Importa a anotação Getter do Lombok, que gera automaticamente os métodos get()
import lombok.Getter;
// Importa a anotação Setter do Lombok, que gera automaticamente os métodos set()
import lombok.Setter;

/**
 * DTO responsável por transportar os dados do usuário
 * e aplicar validações antes de chegar no Service
 */

@Getter // Gera automaticamente os métodos getters para todos os atributos da classe
@Setter // Gera automaticamente os métodos setters para todos os atributos da classe
public class UsuarioDTO {

    // Identificador do usuário
    // Pode ser nulo no momento do cadastro
    private Long id;

    // Nome do usuário
    // Não pode ser vazio nem nulo
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    // Email do usuário
    // Email obrigatório e deve ser em formato válido
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    // Tipo do usuário (ex: ADMIN, ALUNO, FUNCIONARIO)
    @NotNull(message = "O tipo do usuário é obrigatório")
    private String tipo;
}