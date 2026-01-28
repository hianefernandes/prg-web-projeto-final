// Importa a anotação Getter do Lombok, que gera automaticamente os métodos get()
import lombok.Getter;
// Importa a anotação Setter do Lombok, que gera automaticamente os métodos set()
import lombok.Setter;

@Getter // Gera automaticamente os métodos getters para todos os atributos da classe
@Setter // Gera automaticamente os métodos setters para todos os atributos da classe

// DTO responsável por transportar dados do Exemplar
public class ExemplarDTO {

    // Identificador do exemplar
    private Long id;
    // Código único do exemplar
    private String codigo;
    // ID do livro ao qual o exemplar pertence
    private Long livroId;
}