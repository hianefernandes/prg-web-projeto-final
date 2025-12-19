@Component
public class AvaliacaoMapper {

    public Avaliacao toEntity(AvaliacaoDTO dto, Usuario usuario, Livro livro) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setId(dto.getId());
        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());
        avaliacao.setUsuario(usuario);
        avaliacao.setLivro(livro);
        return avaliacao;
    }

    public AvaliacaoDTO toDTO(Avaliacao avaliacao) {
        AvaliacaoDTO dto = new AvaliacaoDTO();
        dto.setId(avaliacao.getId());
        dto.setNota(avaliacao.getNota());
        dto.setComentario(avaliacao.getComentario());
        dto.setUsuarioId(avaliacao.getUsuario().getId());
        dto.setLivroId(avaliacao.getLivro().getId());
        return dto;
    }
}