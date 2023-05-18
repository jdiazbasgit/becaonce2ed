package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.Data;
import once.curso.proyectobanco.entities.TransactionsAwardsFine;
import once.curso.proyectobanco.services.AwardsFinesTypeServices;
import once.curso.proyectobanco.services.TransactionService;
import once.curso.proyectobanco.services.TransactionsAwardsFineService;

@Data
@SpringBootTest
class TransactinsAwardsFineTests {

	@Autowired
	private TransactionsAwardsFineService transactionsAwardsFineService;
	@Autowired
	private AwardsFinesTypeServices awardsFineTypeServices;
	@Autowired
	private TransactionService transactionService;

	@Test
	public void saveTransactionsAwardsFine() {
		TransactionsAwardsFine transactionsAwardsFine = new TransactionsAwardsFine();
		transactionsAwardsFine.setAwardsFineType(getAwardsFineTypeServices().findById(1).get());
		transactionsAwardsFine.setTransaction(getTransactionService().findById(1).get());
		getTransactionsAwardsFineService().save(transactionsAwardsFine);

		getTransactionsAwardsFineService().deleteById(transactionsAwardsFine.getId());
		assertFalse(getTransactionsAwardsFineService().existsById(transactionsAwardsFine.getId()));
	}

	@Test
	public void findAll() {
		List<TransactionsAwardsFine> transactionsAwardsFine = (List<TransactionsAwardsFine>) getTransactionsAwardsFineService()
				.findAll();
		assertNotEquals(transactionsAwardsFine.size(), 0);

	}

	@Test
	public void saveAllTransactionsAwardsFine() {
		long cantidad = getTransactionsAwardsFineService().count();
		List<TransactionsAwardsFine> transactinsAwardsFines = new ArrayList<>();

		TransactionsAwardsFine transactionawardsFine1 = new TransactionsAwardsFine();
		transactionawardsFine1.setAwardsFineType(awardsFineTypeServices.findById(2).get());
		transactionawardsFine1.setTransaction(transactionService.findById(2).get());
		transactinsAwardsFines.add(transactionawardsFine1);

		TransactionsAwardsFine transactionsAwardsFine2 = new TransactionsAwardsFine();
		transactionsAwardsFine2.setAwardsFineType(awardsFineTypeServices.findById(3).get());
		transactionsAwardsFine2.setTransaction(transactionService.findById(3).get());
		transactinsAwardsFines.add(transactionsAwardsFine2);

		getTransactionsAwardsFineService().saveAll(transactinsAwardsFines);
		assertEquals(cantidad + 2, getTransactionsAwardsFineService().count());
		getTransactionsAwardsFineService().delete(transactionawardsFine1);
		getTransactionsAwardsFineService().delete(transactionsAwardsFine2);

	}

	@Test
	public void existsById() {

		assertTrue(getTransactionsAwardsFineService().existsById(10));
	}

	@Test
	public void findAllById() {
		List<TransactionsAwardsFine> datosCompletos = (List<TransactionsAwardsFine>) getTransactionsAwardsFineService()
				.findAll();
		List<Integer> idsCompletos = new ArrayList<Integer>();
		datosCompletos.forEach(dc -> idsCompletos.add(dc.getId()));
		List<TransactionsAwardsFine> datosNuevos = (List<TransactionsAwardsFine>) getTransactionsAwardsFineService()
				.findAllById(idsCompletos);
		assertEquals(datosCompletos.size(),datosNuevos.size());

	}

	@Test
	public void count() {

		assertTrue((getTransactionsAwardsFineService().count() > 0));
	}
}
