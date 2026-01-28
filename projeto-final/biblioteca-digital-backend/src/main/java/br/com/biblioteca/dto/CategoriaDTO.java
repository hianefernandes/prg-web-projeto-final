// Define o pacote onde ficam os DTOs relacionados à Categoria
package br.com.biblioteca.dto;

// Importa o Lombok para geração automática dos getters
import lombok.Getter;
// Importa o Lombok para geração automática dos setters
import lombok.Setter;

@Getter // Gera getters para todos os atributos
@Setter // Gera setters para todos os atributos

// DTO utilizado para transportar dados da Categoria
public class CategoriaDTO {
    
    // Identificador da categoria
    private Long id;
    // Nome da categoria (ex: Romance, Ficção, Tecnologia)
    private String nome;
    // Descrição da categoria
    private String descricao;
}