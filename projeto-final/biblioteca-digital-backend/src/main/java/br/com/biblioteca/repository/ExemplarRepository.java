package br.com.biblioteca.repository;

import br.com.biblioteca.entity.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {
}