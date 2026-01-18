@Entity
@Table(name = "usuarios")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    /**
     * Identificador único do usuário
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do usuário
     */
    private String nome;

    /**
     * Email do usuário (usado para validação de duplicidade)
     */
    private String email;

    /**
     * Senha do usuário
     */
    private String senha;

    /**
     * Tipo do usuário (ex: ADMIN, BIBLIOTECARIO, LEITOR)
     */
    private String tipo;
}