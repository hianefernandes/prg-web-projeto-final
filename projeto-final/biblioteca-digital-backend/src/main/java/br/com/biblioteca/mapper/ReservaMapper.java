@Component
public class ReservaMapper {

    public Reserva toEntity(ReservaDTO dto, Usuario usuario, Livro livro) {
        Reserva reserva = new Reserva();
        reserva.setId(dto.getId());
        reserva.setUsuario(usuario);
        reserva.setLivro(livro);
        reserva.setDataReserva(dto.getDataReserva());
        return reserva;
    }

    public ReservaDTO toDTO(Reserva reserva) {
        ReservaDTO dto = new ReservaDTO();
        dto.setId(reserva.getId());
        dto.setUsuarioId(reserva.getUsuario().getId());
        dto.setLivroId(reserva.getLivro().getId());
        dto.setDataReserva(reserva.getDataReserva());
        return dto;
    }
}