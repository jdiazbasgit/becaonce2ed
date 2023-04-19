package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.TypeAccount;
import once.curso.proyectobanco.services.TypeAccountService;

@SpringBootTest
@Data
public class TypeAccountTest {
	
	@Autowired
	private TypeAccountService typeAccountService;
	
	@Test
	public void testTypeAccount() {
		Iterable<TypeAccount> typesAccounts=typeAccountService.dameTipoDeCuenta();
		assertNotNull(typesAccounts);
	}

}
