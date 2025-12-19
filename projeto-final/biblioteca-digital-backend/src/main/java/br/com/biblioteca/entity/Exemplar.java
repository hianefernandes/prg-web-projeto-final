package br.com.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exemplares")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String status; // DISPONIVEL | EMPRESTADO

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;
}