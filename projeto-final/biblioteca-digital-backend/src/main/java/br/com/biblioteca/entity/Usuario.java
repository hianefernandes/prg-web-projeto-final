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

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "usuarios") // Define explicitamente o nome da tabela no banco de dados
@Getter // Gera automaticamente os métodos getters
@Setter // Gera automaticamente os métodos setters
@NoArgsConstructor // Gera um construtor sem argumentos (exigido pelo JPA)
@AllArgsConstructor // Gera um construtor com todos os atributos
public class Usuario {

    // Define o atributo como chave primária da tabela
    @Id
    // Define que o ID será gerado automaticamente pelo banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identificador único do usuário
    private Long id;

    // Nome do usuário
    private String nome;

    // Email do usuário
    // Pode ser usado para validação de duplicidade
    private String email;

    // Senha do usuário
    // Idealmente deve ser armazenada criptografada
    private String senha;

    // Tipo do usuário (ADMIN, BIBLIOTECARIO, LEITOR)
    private String tipo;
}