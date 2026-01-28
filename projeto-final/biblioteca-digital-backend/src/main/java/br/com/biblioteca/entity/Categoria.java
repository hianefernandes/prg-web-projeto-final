// Define o pacote das entidades
package br.com.biblioteca.entity;

// Importa anotações JPA
import jakarta.persistence.*;
// Importa anotações Lombok
import lombok.*;

@Entity // Define a classe como entidade
@Table(name = "categorias") // Define o nome da tabela no banco
@Getter // Gera automaticamente os métodos getters
@Setter // Gera automaticamente os métodos setters
@NoArgsConstructor // Gera um construtor sem argumentos (exigido pelo JPA)
@AllArgsConstructor // Gera um construtor com todos os atributos
public class Categoria {

    // Define a chave primária
    @Id
    // ID gerado automaticamente pelo banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identificador da categoria
    private Long id;

    // Nome da categoria (ex: Romance, Tecnologia)
    private String nome;
    // Descrição da categoria
    private String descricao;
}