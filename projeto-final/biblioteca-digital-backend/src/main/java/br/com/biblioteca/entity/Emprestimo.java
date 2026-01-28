// Define o pacote das entidades
package br.com.biblioteca.entity;

// Importa anotações JPA
import jakarta.persistence.*;
// Importa anotações Lombok
import lombok.*;

// Importa a classe LocalDate para trabalhar com datas
import java.time.LocalDate;

@Entity // Define a classe como entidade
@Table(name = "emprestimos") // Define o nome da tabela no banco
@Getter // Gera automaticamente os métodos getters
@Setter // Gera automaticamente os métodos setters
@NoArgsConstructor // Gera um construtor sem argumentos (exigido pelo JPA)
@AllArgsConstructor // Gera um construtor com todos os atributos
public class Emprestimo {

    // Define a chave primária
    @Id
    // ID gerado automaticamente pelo banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identificador do empréstimo
    private Long id;

    // Data em que o empréstimo foi realizado
    private LocalDate dataEmprestimo;
    // Data prevista ou efetiva de devolução
    private LocalDate dataDevolucao;

    @ManyToOne // Muitos empréstimos podem pertencer a um usuário
    @JoinColumn(name = "usuario_id") // Define a coluna de chave estrangeira no banco
    private Usuario usuario; // Usuário que realizou o empréstimo

    @ManyToOne // Muitos empréstimos podem envolver um exemplar
    @JoinColumn(name = "exemplar_id") // Define a FK para exemplar
    private Exemplar exemplar; // Exemplar emprestado
}