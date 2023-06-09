package once.curso.proyectobanco.restcontrollers;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Transaction;
import once.curso.proyectobanco.models.TransactionModelAssembler;
import once.curso.proyectobanco.services.ProfileService;
import once.curso.proyectobanco.services.TransactionService;

@RestController
@Data
@RequestMapping("/once")
public class TransactionRestController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private TransactionModelAssembler transactionModelAssembler;

	@Autowired
	private PagedResourcesAssembler<Transaction> pagedResourcesAssembler;

	@Autowired
	private ProfileService profileService;

	@GetMapping(value = "/transactions/{id}")
	public EntityModel<Transaction> findById(@PathVariable int id) {
		Transaction transaction = getTransactionService().findById(id).get();
		transaction.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(TransactionRestController.class).findById(transaction.getId()))
				.withSelfRel());
		transaction.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class)
				.findById(transaction.getDescription().getId())).withRel("description"));
		transaction.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class)
				.findById(transaction.getCurrentAccount().getId())).withRel("currentAccount"));
		return EntityModel.of(transaction);
	}

	/*
	 * @GetMapping(value = "/transactions") public CollectionModel<Transaction>
	 * findAll() { Iterable<Transaction> transaction =
	 * getTransactionService().findAll(); transaction.forEach(t -> {
	 * t.add(WebMvcLinkBuilder
	 * .linkTo(WebMvcLinkBuilder.methodOn(TransactionRestController.class).findById(
	 * t.getId())) .withSelfRel()); t.add(WebMvcLinkBuilder.
	 * linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class).findById(t
	 * .getDescription().getId())) .withRel("description")); t.add(WebMvcLinkBuilder
	 * .linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class).
	 * findById(t.getCurrentAccount().getId())) .withRel("currentAccount")); });
	 * return CollectionModel.of(transaction); }
	 */

	@GetMapping(value = "/transactions")
	public PagedModel<EntityModel<Transaction>>findAll(@RequestParam(defaultValue = "0") int size, 
			@RequestParam (defaultValue = "0") int page,@RequestParam (required = false) String sort){
		if (size==0) {
			size=(int)getTransactionService().count();
		}
		Sort orden= Sort.by("id");
		if (sort !=null) {
			orden= Sort.by(sort);
			StringTokenizer stringTokenizer = new StringTokenizer(sort,",");
			String campo= stringTokenizer.nextToken();
			String tipoOrden=stringTokenizer.nextToken();
			if (tipoOrden.contentEquals("asc")) {
				orden=Sort.by(campo).ascending();
			}
			else {
				orden= Sort.by(campo).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, orden);
		Page<Transaction> transaction=getTransactionService().findAll(pageable);
		return getPagedResourcesAssembler().toModel(transaction, getTransactionModelAssembler());
				
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
