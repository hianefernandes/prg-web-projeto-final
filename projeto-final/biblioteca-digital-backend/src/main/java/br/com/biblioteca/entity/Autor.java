// Define o pacote onde ficam as entidades do sistema.
// As entidades representam as tabelas do banco de dados.
package br.com.biblioteca.entity;

// Importa as anotações do JPA utilizadas para mapear a classe para o banco
import jakarta.persistence.*;
// Importa as anotações do Lombok para reduzir código repetitivo
import lombok.*;

// Indica que esta classe é uma entidade JPA
// Ou seja, será mapeada para uma tabela no banco de dados
@Entity
// Define explicitamente o nome da tabela no banco de dados
@Table(name = "autores")
// Gera automaticamente os métodos getters
@Getter
// Gera automaticamente os métodos setters
@Setter
// Gera um construtor sem argumentos (exigido pelo JPA)
@NoArgsConstructor
// Gera um construtor com todos os atributos
@AllArgsConstructor
public class Autor {

    // Define o atributo como chave primária da tabela
    @Id
    // Define que o ID será gerado automaticamente pelo banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identificador único do autor
    private Long id;

    // Nome do autor
    private String nome;
    // Nacionalidade do autor
    private String nacionalidade;
}