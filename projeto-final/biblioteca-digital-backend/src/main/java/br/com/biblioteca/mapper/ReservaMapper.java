// Permite que o Spring injete essa classe
import org.springframework.stereotype.Component;

// Importa o DTO de Reserva
// Usado para transportar dados da reserva entre frontend e backend
import br.com.biblioteca.dto.ReservaDTO;
// Importa a entidade Livro
import br.com.biblioteca.entity.Livro;
// Importa a entidade Reesrva
import br.com.biblioteca.entity.Reserva;
// Importa a entidade Usuario
import br.com.biblioteca.entity.Usuario;

/**
 * Mapper da entidade Reserva.
 */
@Component // Permite injeção com @Autowired
public class ReservaMapper {

    /**
     * Converte ReservaDTO para entidade Reserva
     */
    public Reserva toEntity(ReservaDTO dto, Usuario usuario, Livro livro) {
        Reserva reserva = new Reserva(); // Cria uma nova reserva
        reserva.setId(dto.getId()); // Define o ID
        reserva.setUsuario(usuario); // Associa o usuário
        reserva.setLivro(livro); // Associa o livro
        reserva.setDataReserva(dto.getDataReserva()); // Define a data da reserva
        return reserva; // Retorna a entidade
    }

    /**
     * Converte entidade Reserva para DTO
     */
    public ReservaDTO toDTO(Reserva reserva) {
        ReservaDTO dto = new ReservaDTO(); // Cria um novo DTO
        dto.setId(reserva.getId()); // Define o ID
        dto.setUsuarioId(reserva.getUsuario().getId()); // Define o ID do usuário
        dto.setLivroId(reserva.getLivro().getId()); // Define o ID do livro
        dto.setDataReserva(reserva.getDataReserva()); // Define a data da reserva
        return dto; // Retorna o DTO
    }
}