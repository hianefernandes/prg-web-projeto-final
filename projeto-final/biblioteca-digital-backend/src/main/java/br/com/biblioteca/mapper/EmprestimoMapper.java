@Component
public class EmprestimoMapper {

    public Emprestimo toEntity(EmprestimoDTO dto, Usuario usuario, Exemplar exemplar) {
        Emprestimo emp = new Emprestimo();
        emp.setId(dto.getId());
        emp.setUsuario(usuario);
        emp.setExemplar(exemplar);
        emp.setDataEmprestimo(dto.getDataEmprestimo());
        emp.setDataDevolucao(dto.getDataDevolucao());
        return emp;
    }

    public EmprestimoDTO toDTO(Emprestimo emp) {
        EmprestimoDTO dto = new EmprestimoDTO();
        dto.setId(emp.getId());
        dto.setUsuarioId(emp.getUsuario().getId());
        dto.setExemplarId(emp.getExemplar().getId());
        dto.setDataEmprestimo(emp.getDataEmprestimo());
        dto.setDataDevolucao(emp.getDataDevolucao());
        return dto;
    }
}