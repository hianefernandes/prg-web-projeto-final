// Permite que o Spring gerencie essa classe
import org.springframework.stereotype.Component;

// Importa o DTO de Empréstimo
// Usado para transportar dados entre o frontend e o backend
import br.com.biblioteca.dto.EmprestimoDTO;
// Importa a entidade Emprestimo
// Representa a tabela "emprestimos" no banco de dados
import br.com.biblioteca.entity.Emprestimo;
// Importa a entidade Exemplar
// Necessária para associar o empréstimo a um exemplar específico
import br.com.biblioteca.entity.Exemplar;
// Importa a entidade Usuario
// Necessária para associar o empréstimo a um usuário
import br.com.biblioteca.entity.Usuario;

/**
 * Mapper responsável por converter
 * Emprestimo ↔ EmprestimoDTO
 */
@Component // Permite injeção com @Autowired
public class EmprestimoMapper {

    /**
     * Converte EmprestimoDTO em entidade Emprestimo
     *
     * @param dto dados vindos da API
     * @param usuario usuário já buscado no banco
     * @param exemplar exemplar já buscado no banco
     * @return entidade Emprestimo
     */
    public Emprestimo toEntity(EmprestimoDTO dto, Usuario usuario, Exemplar exemplar) {
        Emprestimo emp = new Emprestimo(); // Cria um novo empréstimo
        emp.setId(dto.getId()); // Define o ID do empréstimo
        emp.setUsuario(usuario); // Associa o usuário ao empréstimo
        emp.setExemplar(exemplar); // Associa o exemplar ao empréstimo
        emp.setDataEmprestimo(dto.getDataEmprestimo()); // Define a data do empréstimo
        emp.setDataDevolucao(dto.getDataDevolucao()); // Define a data de devolução
        return emp; // Retorna a entidade pronta
    }

    /**
     * Converte entidade Emprestimo em DTO
     *
     * @param emp entidade vinda do banco
     * @return DTO para resposta da API
     */
    public EmprestimoDTO toDTO(Emprestimo emp) {
        EmprestimoDTO dto = new EmprestimoDTO(); // Cria um novo DTO
        dto.setId(emp.getId()); // Define o ID
        dto.setUsuarioId(emp.getUsuario().getId()); // Define o ID do usuário
        dto.setExemplarId(emp.getExemplar().getId()); // Define o ID do exemplar
        dto.setDataEmprestimo(emp.getDataEmprestimo()); // Define a data do empréstimo
        dto.setDataDevolucao(emp.getDataDevolucao()); // Define a data de devolução
        return dto; // Retorna o DTO preenchido
    }
}