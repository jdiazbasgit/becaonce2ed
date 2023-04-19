package once.curso.proyectobanco;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.Data;
import once.curso.proyectobanco.entities.TransactionsAwardsFine;
import once.curso.proyectobanco.services.AwardFineTypeServices;
import once.curso.proyectobanco.services.TransactionService;
import once.curso.proyectobanco.services.TransactionsAwardsFineService;


@Data
@SpringBootTest
	class TransactinsAwardsFineTests {

	@Autowired
	private TransactionsAwardsFineService transactionsAwardsFineService;
	@Autowired
	private  AwardFineTypeServices awardsFineTypeServices;
	@Autowired
	private TransactionService transactionService; 
	
	
	@Test
	public void Prueba() {
		TransactionsAwardsFine transactionsAwardsFine = new TransactionsAwardsFine();
		transactionsAwardsFine.setAwardsFineType(getAwardsFineTypeServices().findById(1).get());
		transactionsAwardsFine.setTransaction(getTransactionService().findById(1).get());
		 getTransactionsAwardsFineService().save(transactionsAwardsFine);
		 //assertTrue(getTransactionsAwardsFineService().existsById(transactionsAwardsFine.getId()));;
		 
		 getTransactionsAwardsFineService().deleteById(transactionsAwardsFine.getId());
		 assertFalse(getTransactionsAwardsFineService().existsById(transactionsAwardsFine.getId()));
	}
	
	@Test
		public void findAll() {
			List<TransactionsAwardsFine> transactionsAwardsFine =(List<TransactionsAwardsFine>) getTransactionsAwardsFineService().findAll();
			assertNotEquals(transactionsAwardsFine.size(),0);
		
		}	

	

}
