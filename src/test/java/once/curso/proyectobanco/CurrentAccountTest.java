package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import lombok.Data;
import once.curso.proyectobanco.entities.CurrentAccount;
import once.curso.proyectobanco.services.CurrentAccountService;

@SpringBootTest
@Data
public class CurrentAccountTest {

	@Autowired
	private CurrentAccountService currentAccountService;
	
	@Test
	@Order(1)
	public void findAllTest() {
		List<CurrentAccount> currentAccount=(List<CurrentAccount>) getCurrentAccountService().findAll();
		assertNotEquals(currentAccount.size(),0);
	}
	@Test
	@Order(2)
	public void testSaveCurrentAccount() {
		CurrentAccount currentAccount = new CurrentAccount();
		currentAccount.setCreationDate(null);;
		getCurrentAccountService().save(currentAccount);
	//	assertNotEquals(typeAccount.getId(), 0);
		assertTrue(getCurrentAccountService().existsById(currentAccount.getId()));
	}

	@Test
	@Order(3)
	public void testDeleteCurrentAccount() {
		Optional<CurrentAccount> currentAccount = getCurrentAccountService().findById(0);
		int id = currentAccount.get().getId();
		if (currentAccount.isPresent())
			getCurrentAccountService().delete(currentAccount.get());
		assertFalse(getCurrentAccountService().existsById(id));
	}

		/*public void testCurrentAccount() {
			Iterable<CurrentAccount> currentAccount=currentAccountService.dameCuentas();
			assertNotNull(currentAccount);
		}*/

	
}
