package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.TransactionAwardFine;
import once.curso.proyectobanco.services.AwardFineTypeService;
import once.curso.proyectobanco.services.TransactionService;
import once.curso.proyectobanco.services.TransactionAwardFineService;

@Data
@SpringBootTest
class TransactinsAwardsFineTests {

	@Autowired
	private TransactionAwardFineService transactionsAwardsFineService;
	@Autowired
	private AwardFineTypeService awardsFineTypeServices;
	@Autowired
	private TransactionService transactionService;

	@Test
	public void saveTransactionsAwardsFine() {
		TransactionAwardFine transactionsAwardsFine = new TransactionAwardFine();
		transactionsAwardsFine.setAwardFineType(getAwardsFineTypeServices().findById(1).get());
		transactionsAwardsFine.setTransaction(getTransactionService().findById(1).get());
		getTransactionsAwardsFineService().save(transactionsAwardsFine);

		getTransactionsAwardsFineService().deleteById(transactionsAwardsFine.getId());
		assertFalse(getTransactionsAwardsFineService().existsById(transactionsAwardsFine.getId()));
	}

	@Test
	public void findAll() {
		List<TransactionAwardFine> transactionsAwardsFine = (List<TransactionAwardFine>) getTransactionsAwardsFineService()
				.findAll();
		assertNotEquals(transactionsAwardsFine.size(), 0);

	}

	@Test
	public void saveAllTransactionsAwardsFine() {
		long cantidad = getTransactionsAwardsFineService().count();
		List<TransactionAwardFine> transactinsAwardsFines = new ArrayList<>();

		TransactionAwardFine transactionawardsFine1 = new TransactionAwardFine();
		transactionawardsFine1.setAwardFineType(awardsFineTypeServices.findById(2).get());
		transactionawardsFine1.setTransaction(transactionService.findById(2).get());
		transactinsAwardsFines.add(transactionawardsFine1);

		TransactionAwardFine transactionsAwardsFine2 = new TransactionAwardFine();
		transactionsAwardsFine2.setAwardFineType(awardsFineTypeServices.findById(3).get());
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
		List<TransactionAwardFine> datosCompletos = (List<TransactionAwardFine>) getTransactionsAwardsFineService().findAll();
	
		List<Integer> idsCompletos = new ArrayList<Integer>();
		datosCompletos.forEach(dc -> idsCompletos.add(dc.getId()));
		List<TransactionAwardFine> datosNuevos = (List<TransactionAwardFine>) getTransactionsAwardsFineService()
				.findAllById(idsCompletos);
		assertEquals(datosCompletos.size(),datosNuevos.size());

	}

	@Test
	public void count() {

		assertTrue((getTransactionsAwardsFineService().count() > 0));
	}
}
