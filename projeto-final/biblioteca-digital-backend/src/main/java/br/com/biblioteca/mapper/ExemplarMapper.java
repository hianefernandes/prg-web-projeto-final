@Component
public class ExemplarMapper {

    public Exemplar toEntity(ExemplarDTO dto, Livro livro) {
        Exemplar exemplar = new Exemplar();
        exemplar.setId(dto.getId());
        exemplar.setCodigo(dto.getCodigo());
        exemplar.setLivro(livro);
        return exemplar;
    }

    public ExemplarDTO toDTO(Exemplar exemplar) {
        ExemplarDTO dto = new ExemplarDTO();
        dto.setId(exemplar.getId());
        dto.setCodigo(exemplar.getCodigo());
        dto.setLivroId(exemplar.getLivro().getId());
        return dto;
    }
}