package br.com.biblioteca.biblioteca_digital;

// Importa a classe responsável por iniciar a aplicação Spring Boot
import org.springframework.boot.SpringApplication;
// Importa a classe responsável por iniciar a aplicação Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Importa a anotação que configura a aplicação como Spring Boot
@SpringBootApplication
public class BibliotecaDigitalApplication {

	// Método principal da aplicação
    // É o primeiro método executado quando o projeto é iniciado
	public static void main(String[] args) {
		// Inicializa a aplicação Spring Boot
        // Carrega todas as configurações, controllers, services e repositories
		SpringApplication.run(BibliotecaDigitalApplication.class, args);
	}

}
