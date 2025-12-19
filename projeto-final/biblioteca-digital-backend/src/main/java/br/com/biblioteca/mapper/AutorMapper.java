package br.com.biblioteca.mapper;

import br.com.biblioteca.dto.AutorDTO;
import br.com.biblioteca.entity.Autor;

public class AutorMapper {

    public static AutorDTO toDTO(Autor autor) {
        AutorDTO dto = new AutorDTO();
        dto.setId(autor.getId());
        dto.setNome(autor.getNome());
        dto.setNacionalidade(autor.getNacionalidade());
        return dto;
    }

    public static Autor toEntity(AutorDTO dto) {
        Autor autor = new Autor();
        autor.setId(dto.getId());
        autor.setNome(dto.getNome());
        autor.setNacionalidade(dto.getNacionalidade());
        return autor;
    }
}