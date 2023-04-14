package once.curso.proyectobanco.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
