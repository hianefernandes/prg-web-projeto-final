@Component
public class LivroMapper {

    public Livro toEntity(LivroDTO dto, Autor autor, Categoria categoria) {
        Livro livro = new Livro();
        livro.setId(dto.getId());
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(autor);
        livro.setCategoria(categoria);
        return livro;
    }

    public LivroDTO toDTO(Livro livro) {
        LivroDTO dto = new LivroDTO();
        dto.setId(livro.getId());
        dto.setTitulo(livro.getTitulo());
        dto.setAutorId(livro.getAutor().getId());
        dto.setCategoriaId(livro.getCategoria().getId());
        return dto;
    }
}