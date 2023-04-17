package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Transaction;
import once.curso.proyectobanco.services.TransactionService;

@RestController
@Data
@RequestMapping ("/once")
public class TransactionRestController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping(value="/transaction/{id}")
	public Transaction findById(@PathVariable Integer id) {
		return getTransactionService().findById(id).get();
	}
	@GetMapping(value = "/transaction")
	public Iterable<Transaction> findAll(@PathVariable Integer id) {
		return getTransactionService().findAll();
	}

	@PostMapping(value = "/transaction")
	public Transaction save(@RequestBody Transaction transaction) {
		return getTransactionService().save(transaction);
	}
	@PostMapping(value="/transaction")
	public List<Transaction> saveAll(@RequestBody List<Transaction> transaction){
		return (List<Transaction>)getTransactionService().saveAll(transaction);
	}
	@DeleteMapping(value="/transaction/{id}")
	public void deleteById(@PathVariable Integer id) {
		getTransactionService().deleteById(id);
	}
}
