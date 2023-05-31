package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	@GetMapping("/transactionsAwardsFineService")
	
	public CollectionModel<TransactionsAwardsFine> findAll(){
	Iterable<TransactionsAwardsFine> transactionsAwardsFine = getTransactionsAwardsFineService().findAll();
	transactionsAwardsFine.forEach(t ->{
		t.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TransactionRestController.class)
			.findById(t.getTransaction().getId())).withRel("transaction"));
		
		t.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestControllers.class)
				.findById(t.getAwardsFineType().getId())).withRel("AwardsFineType"));
		t.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TransactionsAwardsFineResController.class)
				.findById(t.getId())).withSelfRel());
	});
		return CollectionModel.of( transactionsAwardsFine);
	}
	
	@GetMapping(value="/transactionsAwardsFineService/{id}")
	
	public EntityModel<TransactionsAwardsFine> findById(@PathVariable Integer id){
		 TransactionsAwardsFine transactionsAwardsFine =getTransactionsAwardsFineService().findById(id).get();
		 transactionsAwardsFine.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TransactionsAwardsFineResController.class)
				.findById(transactionsAwardsFine.getId())).withSelfRel());
			
		return EntityModel.of(transactionsAwardsFine);
}
	@PostMapping("/transactionsAwardsFineService")
		
	public TransactionsAwardsFine save(@RequestBody TransactionsAwardsFine transactionsAwardsFine) {
		return getTransactionsAwardsFineService().save(transactionsAwardsFine);
	
	}
	
	@PutMapping(value="/transactionsAwardsFineService")
	public List<TransactionsAwardsFine> saveAll(@RequestBody List<TransactionsAwardsFine> transactionsAwardsFines){
		return (List<TransactionsAwardsFine>)getTransactionsAwardsFineService().saveAll(transactionsAwardsFines);
	}
	
	@DeleteMapping("/transactionsAwardsFineService")
	public void deleteById(@PathVariable Integer id) {
		getTransactionsAwardsFineService().deleteById(id);
	}



	
}