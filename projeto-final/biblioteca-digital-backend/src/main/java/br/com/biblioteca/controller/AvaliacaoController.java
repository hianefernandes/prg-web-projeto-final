@RestController
@RequestMapping("/avaliacoes")
@RequiredArgsConstructor
@CrossOrigin
public class AvaliacaoController {

    private final AvaliacaoService service;

    @PostMapping
    public AvaliacaoDTO criar(@RequestBody AvaliacaoDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<AvaliacaoDTO> listar() {
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}