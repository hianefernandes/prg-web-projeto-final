// Pacote das entidades
package br.com.biblioteca.entity;

// Importa as anotações do JPA utilizadas para mapear a classe para o banco
import jakarta.persistence.*;
// Importa as anotações do Lombok para reduzir código repetitivo
import lombok.*;

@Entity  // Indica que esta classe é uma entidade JPA
@Table(name = "livros") // Define explicitamente o nome da tabela no banco de dados
@Getter // Gera automaticamente os métodos getters
@Setter // Gera automaticamente os métodos setters
@NoArgsConstructor // Gera um construtor sem argumentos (exigido pelo JPA)
@AllArgsConstructor // Gera um construtor com todos os atributos
public class Livro {

    // Define o atributo como chave primária da tabela
    @Id
    // Define que o ID será gerado automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identificador unico do livro
    private Long id;

    private String titulo;  // Título do livro
    private String isbn;  // Código ISBN do livro
    private Integer anoPublicacao;  // Ano de publicação do livro

    @ManyToOne  // Muitos livros podem ter o mesmo autor
    @JoinColumn(name = "autor_id")  // FK para Autor
    private Autor autor;  // Autor do livro

    @ManyToOne  // Muitos livros podem pertencer a uma categoria
    @JoinColumn(name = "categoria_id")  // FK para Categoria
    private Categoria categoria;  // Categoria do livro
}