// Importa a anotação Entity que indica que a classe é uma entidade JPA
import jakarta.persistence.Entity;
// Importa a anotação para gerar valores automaticos
import jakarta.persistence.GeneratedValue;
// Importa os tipos de estrategia de geração de ID
import jakarta.persistence.GenerationType;
// Importa a anotação utilizada para criar relacionamento entre entidades
import jakarta.persistence.ManyToOne;
// Importa a anotação usada para definir o nome da tabela no banco de dados
import jakarta.persistence.Table;
// Importa a anotação do lombok que cria automaticamente um construtor com todos os atributos
import lombok.AllArgsConstructor;
// Importa a anotação que gera automaticamente todos os getters
import lombok.Getter;
// Importa a anotação que cria automaticamente um construtor sem parametros
import lombok.NoArgsConstructor;
// Importa a anotação que gera automaticamente todos os setters
import lombok.Setter;

// Indica que a classe é uma entidade JPA
@Entity
// Define o nome da tabela no banco de dados
@Table(name = "avaliacoes")
// Gera automaticamente os métodos getters
@Getter
// Gera automaticamente os métodos setters
@Setter
// Gera um construtor sem argumentos (exigido pelo JPA)
@NoArgsConstructor
// Gera um construtor com todos os atributos
@AllArgsConstructor
public class Avaliacao {

    // Define a chave primária da entidade
    @Id
    // O banco será responsável por gerar o ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identificador da avaliação
    private Long id;

    // Nota atribuída à avaliação
    // Geralmente varia de 1 a 5
    private Integer nota;

    // Comentário textual do usuário sobre o livro
    private String comentario;

    // Define um relacionamento muitos-para-um
    // Muitas avaliações podem pertencer a um usuário
    @ManyToOne
    private Usuario usuario; // Usuário que realizou a avaliação

    // Define um relacionamento muitos-para-um
    // Muitos registros de avaliação podem estar associados a um livro
    @ManyToOne
    private Livro livro; // Livro que foi avaliado
}