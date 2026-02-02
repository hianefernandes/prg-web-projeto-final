// Define o pacote repository
package br.com.biblioteca.repository;

// Importa a entidade Reserva
// Representa a tabela "reservas" no banco
import br.com.biblioteca.entity.Reserva;
// Importa o JpaRepository do Spring
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository responsável pelo acesso aos dados
 * relacionados às reservas de livros.
 */
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Não há métodos customizados por enquanto
}