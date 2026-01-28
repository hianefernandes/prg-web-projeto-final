// Importa a anotação Getter do Lombok, que gera automaticamente os métodos get()
import lombok.Getter;
// Importa a anotação Setter do Lombok, que gera automaticamente os métodos set()
import lombok.Setter;

@Getter // Gera automaticamente os métodos getters para todos os atributos da classe
@Setter // Gera automaticamente os métodos setters para todos os atributos da classe

// DTO responsável por transportar dados do Livro
public class LivroDTO {

    // Identificador do livro
    private Long id;
    // Título do livro
    private String titulo;
    // ID do autor do livro
    private Long autorId;
    // ID da categoria do livro
    private Long categoriaId;
}