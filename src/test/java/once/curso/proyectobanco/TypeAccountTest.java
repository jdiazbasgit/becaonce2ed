package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.TypeAccount;
import once.curso.proyectobanco.services.TypeAccountService;

@SpringBootTest
@Data
@TestMethodOrder(OrderAnnotation.class)
public class TypeAccountTest {

	@Autowired
	private TypeAccountService typeAccountService;

	@Test
	@Order(1)
	public void testTypeAccount() {
		List<TypeAccount> typesAccounts = (List<TypeAccount>) getTypeAccountService().findAll();
		assertNotEquals(typesAccounts.size(), 0);
	}

	@Test
	@Order(2)
	public void testSaveTypeAccount() {
		TypeAccount typeAccount = new TypeAccount();
		typeAccount.setDescription("prueba de oscar");
		getTypeAccountService().save(typeAccount);
	//	assertNotEquals(typeAccount.getId(), 0);
		assertTrue(getTypeAccountService().existsById(typeAccount.getId()));
	}

	@Test
	@Order(3)
	public void testDeleteTypeAccount() {
		Optional<TypeAccount> typeAccount = getTypeAccountService().findByDescriptionEquals("prueba de oscar");
		int id = typeAccount.get().getId();
		if (typeAccount.isPresent())
			getTypeAccountService().delete(typeAccount.get());
		assertFalse(getTypeAccountService().existsById(id));
	}

}
