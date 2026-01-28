// Define o pacote onde o DTO Autor está localizado.
// DTOs ficam separados das entidades para organização e segurança.
package br.com.biblioteca.dto;

// Importa a anotação Getter do Lombok, que gera automaticamente os métodos get()
import lombok.Getter;
// Importa a anotação Setter do Lombok, que gera automaticamente os métodos set()
import lombok.Setter;

@Getter // Gera automaticamente os métodos getters para todos os atributos da classe
@Setter // Gera automaticamente os métodos setters para todos os atributos da classe

/**
* Classe DTO utilizada para transportar dados do Autor
* entre Controller e Service, sem expor a entidade diretamente
*/
public class AutorDTO {

    // Identificador do autor
    // Pode ser nulo no cadastro e preenchido automaticamente pelo banco
    private Long id;
    // Nome do autor
    private String nome;
    // Nacionalidade do autor
    private String nacionalidade;
}