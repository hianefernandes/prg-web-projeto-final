@Entity
@Table(name = "avaliacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer nota; // 1 a 5

    private String comentario;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Livro livro;
}