@Service
@RequiredArgsConstructor
public class AvaliacaoService {

    private final AvaliacaoRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final LivroRepository livroRepository;
    private final AvaliacaoMapper mapper;

    public AvaliacaoDTO salvar(AvaliacaoDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Livro livro = livroRepository.findById(dto.getLivroId())
            .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Avaliacao avaliacao = mapper.toEntity(dto, usuario, livro);
        return mapper.toDTO(repository.save(avaliacao));
    }

    public List<AvaliacaoDTO> listar() {
        return repository.findAll().stream()
            .map(mapper::toDTO)
            .toList();
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}