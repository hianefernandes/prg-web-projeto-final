package br.com.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "livros")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String isbn;
    private Integer anoPublicacao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}