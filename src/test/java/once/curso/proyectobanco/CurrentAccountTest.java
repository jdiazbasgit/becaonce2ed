package once.curso.proyectobanco;




import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.CurrentAccount;
import once.curso.proyectobanco.services.CurrentAccountService;

@SpringBootTest
@Data
public class CurrentAccountTest {

	@Autowired
	private CurrentAccountService currentAccountService;
	
	@Test
	public void findAllTest() {
		List<CurrentAccount> currentAccount=(List<CurrentAccount>) getCurrentAccountService().findAll();
		assertNotEquals(currentAccount.size(),0);
	}
	
	
}
