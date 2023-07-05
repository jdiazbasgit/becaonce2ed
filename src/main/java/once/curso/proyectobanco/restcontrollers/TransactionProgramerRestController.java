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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Transaction;
import once.curso.proyectobanco.entities.TransactionProgramer;
import once.curso.proyectobanco.models.TransactionModelAssembler;
import once.curso.proyectobanco.models.TransactionProgramerModelAssembler;
import once.curso.proyectobanco.services.TransactionProgramerService;
import once.curso.proyectobanco.services.TransactionService;

@RestController
@Data
@RequestMapping("/once")
@CrossOrigin(origins = "*")
public class TransactionProgramerRestController {
	
	@Autowired
	private TransactionProgramerService transactionProgramerService;

	@Autowired
	private TransactionProgramerModelAssembler transactionProgramerModelAssembler;

	@Autowired
	private PagedResourcesAssembler<TransactionProgramer> pagedResourcesAssembler;

	@GetMapping(value = "/transactionsProgramers/{id}")
	@CrossOrigin(origins = "*")
	public EntityModel<TransactionProgramer> findById(@PathVariable int id) {
		TransactionProgramer transactionProgramer = getTransactionProgramerService().findById(id).get();
		transactionProgramer.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(TransactionRestController.class).findById(transactionProgramer.getId()))
				.withSelfRel());
		transactionProgramer.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class)
				.findById(transactionProgramer.getDescription().getId())).withRel("description"));
		transactionProgramer.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class)
				.findById(transactionProgramer.getCurrentAccount().getId())).withRel("currentAccount"));
		transactionProgramer.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TimingTypeRestController.class)
				.findById(transactionProgramer.getTimingType().getId())).withRel("timingType"));
		return EntityModel.of(transactionProgramer);
	}

	

	@GetMapping(value = "/transactionsProgramers")
	public PagedModel<EntityModel<TransactionProgramer>> findAll(@RequestParam(defaultValue = "0") int size,
			@RequestParam(defaultValue = "0") int page, @RequestParam(required = false) String sort) {
		if (size == 0) {
			size = (int) getTransactionProgramerService().count();
		}
		Sort orden = Sort.by("id");
		if (sort != null) {
			orden = Sort.by(sort);
			StringTokenizer stringTokenizer = new StringTokenizer(sort, ",");
			String campo = stringTokenizer.nextToken();
			String tipoOrden = stringTokenizer.nextToken();
			if (tipoOrden.contentEquals("asc")) {
				orden = Sort.by(campo).ascending();
			} else {
				orden = Sort.by(campo).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, orden);
		Page<TransactionProgramer> transaction = getTransactionProgramerService().findAll(pageable);
		return getPagedResourcesAssembler().toModel(transaction, getTransactionProgramerModelAssembler());

	}
	
	@PostMapping(value = "/transactionsProgramers")
	public boolean save(@RequestBody TransactionProgramer transactionProgramer) {
		return getTransactionProgramerService().existsById(getTransactionProgramerService().save(transactionProgramer).getId());
	}

	@PutMapping(value = "/transactionsProgramers")
	public List<TransactionProgramer> saveAll(@RequestBody List<TransactionProgramer> transactionProgramer) {
		return (List<TransactionProgramer>) getTransactionProgramerService().saveAll(transactionProgramer);
	}

	@DeleteMapping(value = "/transactionsProgramers/{id}")
	public void deleteById(@PathVariable Integer id) {
		getTransactionProgramerService().deleteById(id);
	}

	@PostMapping(value = "/transactionsProgramers/{id}")
	public boolean existsById(@PathVariable int id) {
		return getTransactionProgramerService().existsById(id);
	}
	

}
