// Define o pacote onde esta classe está localizada.
// Geralmente fica igual ao pacote principal da aplicação
package br.com.biblioteca.biblioteca_digital;

// Importa a anotação @Test do JUnit 5,
// usada para indicar que um método é um teste automatizado
import org.junit.jupiter.api.Test;
// Importa a anotação @SpringBootTest
// que carrega todo o contexto da aplicação Spring para testes de integração
import org.springframework.boot.test.context.SpringBootTest;

// Anotação que indica que o Spring Boot deve
// inicializar todo o contexto da aplicação para executar os testes
@SpringBootTest
class BibliotecaDigitalApplicationTests {

	// Anotação que indica que este método é um teste
	@Test
	void contextLoads() {
		// Método de teste vazio.
        // Ele serve apenas para verificar se a aplicação
        // consegue subir o contexto do Spring sem erros.
	}

}
