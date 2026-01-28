// Pacote das entidades
package br.com.biblioteca.entity;

// Importa as anotações do JPA utilizadas para mapear a classe para o banco
import jakarta.persistence.*;
// Importa as anotações do Lombok para reduzir código repetitivo
import lombok.*;

// Importa a classe LocalDate para trabalhar com datas
import java.time.LocalDate;

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "reservas") // Define explicitamente o nome da tabela no banco de dados
@Getter // Gera automaticamente os métodos getters
@Setter // Gera automaticamente os métodos setters
@NoArgsConstructor // Gera um construtor sem argumentos (exigido pelo JPA)
@AllArgsConstructor // Gera um construtor com todos os atributos
public class Reserva {

    // Define o atributo como chave primária da tabela
    @Id
    // Define que o ID será gerado automaticamente no banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identificador da reserva
    private Long id;

    private LocalDate dataReserva;  // Data em que a reserva foi realizada
    private String status; // Status da reserva (ATIVA ou CANCELADA)

    @ManyToOne // Muitas reservas podem pertencer a um usuário
    @JoinColumn(name = "usuario_id")  // FK do usuário
    private Usuario usuario;  // Usuário que realizou a reserva

    @ManyToOne // Muitas reservas podem estar associadas a um livro
    @JoinColumn(name = "livro_id")    // FK do livro
    private Livro livro;  // Livro reservado
}