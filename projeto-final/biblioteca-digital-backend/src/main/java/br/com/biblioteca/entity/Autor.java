package br.com.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "autores")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String nacionalidade;
}