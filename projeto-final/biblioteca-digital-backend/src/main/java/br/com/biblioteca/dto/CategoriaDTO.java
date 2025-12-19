package br.com.biblioteca.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CategoriaDTO {
    private Long id;
    private String nome;
    private String descricao;
}