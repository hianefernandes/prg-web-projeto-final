// Define o pacote principal da aplicação.
// Todas as classes abaixo desse pacote serão escaneadas automaticamente pelo Spring
package br.com.biblioteca;

// Importa a classe SpringApplication,
// responsável por inicializar a aplicação Spring Boot
import org.springframework.boot.SpringApplication;
// Importa a anotação @SpringBootApplication, que habilita configurações automáticas,
// escaneamento de componentes e configuração do Spring
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotação principal do Spring Boot.
// Equivale a: @Configuration   @EnableAutoConfiguration   @ComponentScan
@SpringBootApplication
public class BibliotecaDigitalApplication {

    // Método principal da aplicação Java
    // É o ponto de entrada do sistema
    public static void main(String[] args) {
        // Inicializa a aplicação Spring Boot,
        // criando o contexto e iniciando o servidor
        SpringApplication.run(BibliotecaDigitalApplication.class, args);
    }
}