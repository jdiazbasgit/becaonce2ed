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
import once.curso.proyectobanco.entities.Transaction;
import once.curso.proyectobanco.services.TransactionService;

@RestController
@Data
@RequestMapping("/once")
public class TransactionRestController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping(value="/transactions/{id}")
	public EntityModel<Transaction> findById(@PathVariable int id) {
		Transaction transaction=getTransactionService().findById(id).get();
			transaction.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TransactionRestController.class).
					findById(transaction.getId())).withSelfRel());
			transaction.add(WebMvcLinkBuilder.
					linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class).findById(transaction.getDescription().getId()))
					.withRel("description"));
			transaction.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class).findById(transaction.getCurrentAccount().getId()))
					.withRel("currentAccount"));
		return EntityModel.of(transaction);
	}

	@GetMapping(value = "/transactions")
	public CollectionModel<Transaction> findAll() {
		Iterable<Transaction> transaction = getTransactionService().findAll();
		transaction.forEach(t -> {
			t.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(TransactionRestController.class).findById(t.getId()))
					.withSelfRel());
			t.add(WebMvcLinkBuilder.
					linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class).findById(t.getDescription().getId()))
					.withRel("description"));
			t.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class).findById(t.getCurrentAccount().getId()))
					.withRel("currentAccount"));
		});
		return CollectionModel.of(transaction);
	}

	@PostMapping(value = "/transactions")
	public Transaction save(@RequestBody Transaction transaction) {
		return getTransactionService().save(transaction);
	}

	@PutMapping(value = "/transactions")
	public List<Transaction> saveAll(@RequestBody List<Transaction> transaction) {
		return (List<Transaction>) getTransactionService().saveAll(transaction);
	}

	@DeleteMapping(value = "/transactions/{id}")
	public void deleteById(@PathVariable Integer id) {
		getTransactionService().deleteById(id);
	}
}
