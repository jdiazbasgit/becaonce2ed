package once.curso.proyectobanco.restcontrollers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.TransactionsAwardsFine;
import once.curso.proyectobanco.services.TransactionsAwardsFineService;

@Data
@RestController
@RequestMapping("/once")
public class TransactionsAwardsFineResController {
	
	@Autowired
	private TransactionsAwardsFineService transactionsAwardsFineService;
	
	
	@PostMapping("/transactionsAwardsFineService")
	
	public List<TransactionsAwardsFine> dameDato(){
		return (List<TransactionsAwardsFine>) getTransactionsAwardsFineService().findAll();
	}
	
	@PostMapping(value="/transactionsAwardsFineService/{id}")
	
	public TransactionsAwardsFine findById(@PathVariable Integer id){
		return getTransactionsAwardsFineService().findById(id).get();
			
		
}
	@PostMapping("/transactionsAwardsFineService")
		
	public TransactionsAwardsFine save(@RequestBody TransactionsAwardsFine transactionsAwardsFine) {
		return getTransactionsAwardsFineService().save(transactionsAwardsFine);
	
	}
	
	@PostMapping(value="/transactionsAwardsFineService")
	public List<TransactionsAwardsFine> saveAll(@RequestBody List<TransactionsAwardsFine> transactionsAwardsFines){
		return (List<TransactionsAwardsFine>)getTransactionsAwardsFineService().saveAll(transactionsAwardsFines);
	}
	
	@DeleteMapping("/transactionsAwardsFineService")
	public void deleteById(@PathVariable Integer id) {
		getTransactionsAwardsFineService().deleteById(id);
	}



	
}