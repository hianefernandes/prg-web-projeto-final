@Getter
@Setter
public class EmprestimoDTO {
    private Long id;
    private Long usuarioId;
    private Long exemplarId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
}