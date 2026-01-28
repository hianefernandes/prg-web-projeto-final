// Pacote das entidades
package br.com.biblioteca.entity;

// Importa as anotações do JPA utilizadas para mapear a classe para o banco
import jakarta.persistence.*;
// Importa as anotações do Lombok para reduzir código repetitivo
import lombok.*;

// Indica que esta classe é uma entidade JPA
// Ou seja, será mapeada para uma tabela no banco de dados
@Entity
// Define explicitamente o nome da tabela no banco de dados
@Table(name = "exemplares")
// Gera automaticamente os métodos getters
@Getter
// Gera automaticamente os métodos setters
@Setter
// Gera um construtor sem argumentos (exigido pelo JPA)
@NoArgsConstructor
// Gera um construtor com todos os atributos
@AllArgsConstructor
public class Exemplar {

    // Define o atributo como chave primária
    @Id
    // Define que o ID será gerado automaticamente pelo banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identificador do exemplar
    private Long id;

    // Código único do exemplar físico
    private String codigo;
    // Status do exemplar (ex: DISPONIVEL ou EMPRESTADO)
    private String status;

    @ManyToOne // Muitos exemplares podem estar associados a um livro
    @JoinColumn(name = "livro_id") // Define a chave estrangeira
    private Livro livro;  // Livro ao qual o exemplar pertence
}