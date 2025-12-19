package br.com.biblioteca.dto;

import lombok.*;

@Getter @Setter
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String tipo;
}