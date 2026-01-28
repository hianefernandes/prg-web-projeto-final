// Importa a classe LocalDate para trabalhar com datas
import java.time.LocalDate;

// Importa a anotação Getter do Lombok, que gera automaticamente os métodos get()
import lombok.Getter;
// Importa a anotação Setter do Lombok, que gera automaticamente os métodos set()
import lombok.Setter;

@Getter // Gera automaticamente os métodos getters para todos os atributos da classe
@Setter // Gera automaticamente os métodos setters para todos os atributos da classe

// DTO responsável por transportar dados da Reserva
public class ReservaDTO {
    // Identificador da reserva
    private Long id;
    // ID do usuário que realizou a reserva
    private Long usuarioId;
    // ID do livro reservado
    private Long livroId;
    // Data em que a reserva foi realizada
    private LocalDate dataReserva;
}