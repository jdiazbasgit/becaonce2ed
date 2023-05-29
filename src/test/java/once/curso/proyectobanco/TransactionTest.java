package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.CurrentAccount;
import once.curso.proyectobanco.entities.Description;
import once.curso.proyectobanco.entities.Transaction;
import once.curso.proyectobanco.services.CurrentAccountService;
import once.curso.proyectobanco.services.DescriptionService;
import once.curso.proyectobanco.services.TransactionService;


@SpringBootTest
@Data
public class TransactionTest {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private DescriptionService descriptionService;
	
	@Autowired
	private CurrentAccountService currentAccountService;
	
	@Test
	public void findAll() {
		List<Transaction> transaction= (List<Transaction>) getTransactionService().findAll();
		assertNotEquals(transaction.size(), 0);
	}
	
	@Test
	public void grabar() {
		Description description=getDescriptionService().findById(1).get();
		CurrentAccount currentAccount=getCurrentAccountService().findById(1).get();
		Transaction transaction= new Transaction();
		transaction.setCurrentAccount(currentAccount);
		transaction.setDescription(description);
		Calendar calendar= Calendar.getInstance();
		calendar.set(2023,02,03);
		transaction.setDate(calendar);
		transaction.setCurrent(0.01);
		getTransactionService().save(transaction);
		assertNotEquals(transaction.getId(), 0);
		
		
		
		
	}

}
