// Importa a anotação Getter do Lombok, que gera automaticamente os métodos get()
import lombok.Getter;
// Importa a anotação Setter do Lombok, que gera automaticamente os métodos set()
import lombok.Setter;

@Getter // Gera automaticamente os métodos getters para os atributos
@Setter // Gera automaticamente os métodos setters para os atributos

/**
* DTO responsável por transportar os dados da avaliação
* entre o frontend e a camada de serviço
*/
public class AvaliacaoDTO {

    // Identificador da avaliação
    private Long id;
    // Nota atribuída na avaliação (ex: 1 a 5)
    private Integer nota;
    // Comentário textual do usuário sobre o livro
    private String comentario;
    // ID do usuário que realizou a avaliação
    // Evita trazer o objeto Usuario completo
    private Long usuarioId;
    // ID do livro avaliado
    private Long livroId;
}