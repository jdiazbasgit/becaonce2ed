package once.curso.proyectobanco.restcontrollers;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import once.curso.proyectobanco.entities.CurrentAccount;
import once.curso.proyectobanco.entities.Description;
import once.curso.proyectobanco.entities.Profile;
import once.curso.proyectobanco.models.CurrentAccountModelAssembler;
import once.curso.proyectobanco.services.CurrentAccountService;

@Data
@RestController
@RequestMapping("/once")
@CrossOrigin(origins = "*")
public class CurrentAccountRestController {
	@Autowired
	private CurrentAccountService currentAccountService;

	@Autowired
	private CurrentAccountModelAssembler currentAccountModelAssembler;

	@Autowired
	private PagedResourcesAssembler<CurrentAccount> PagedResourcesAssembler;

	@GetMapping(value = "/currentAccounts/{id}")
    public EntityModel<CurrentAccount> findById(@PathVariable Integer id) {
        CurrentAccount currentAccount = currentAccountService.findById(id).get();
        currentAccount.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class)
                .findById(currentAccount.getId())).withSelfRel());
        return EntityModel.of(currentAccount);
	}
        
	@GetMapping(value = "/currentAccounts")
    public PagedModel<EntityModel<CurrentAccount>> findAll(@RequestParam int size,@RequestParam int page,@RequestParam String sort){
    	StringTokenizer stringTokenizer = new StringTokenizer(sort,",");
    	Sort orden = Sort.by("a");
    	
    	String campo = stringTokenizer.nextToken();
    	String tipoOrden = stringTokenizer.nextToken();
    	
    	if(tipoOrden.contentEquals("asc"))
    		orden = Sort.by(campo).ascending();
    	else
    		orden = Sort.by(campo).descending();
    	
    	Pageable pageable = PageRequest.of(page, size,orden);
    	Page<CurrentAccount> currentAccount = getCurrentAccountService().findAll(pageable);
    	
    	return getPagedResourcesAssembler().toModel(currentAccount,getCurrentAccountModelAssembler());
    }
    
    

	
	/*public CollectionModel<CurrentAccount> findAll() {
		Iterable<CurrentAccount> currentAccounts = currentAccountService.findAll();
		currentAccounts.forEach(a -> {
			a.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class).findById(a.getId()))
					.withSelfRel());
			a.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(TypeAccountRestController.class).findById(a.getId()))
					.withRel("typeAccount"));
			a.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FeeRestController.class).findById(a.getId()))
					.withRel("fee"));
		});
		return CollectionModel.of(currentAccounts);
	}*/

	/*@PostMapping(value = "/currentAccounts")
	public EntityModel<CurrentAccount> save(@RequestBody CurrentAccount currentAccount) {
		CurrentAccount savedAccount = currentAccountService.save(currentAccount);
		savedAccount.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class).findById(savedAccount.getId()))
				.withSelfRel());
		return EntityModel.of(savedAccount);
	}*/
	
	@PostMapping(value = "/currentAccounts")
	public boolean save(@RequestBody CurrentAccount currentAccount) {
		return getCurrentAccountService().existsById(getCurrentAccountService().save(currentAccount).getId());
	}

	@DeleteMapping(value = "/currentAccounts/{id}")
	public void deleteById(@PathVariable Integer id) {
		currentAccountService.deleteById(id);
	}
	
	@PutMapping("/profiles")
	public List <CurrentAccount> saveAll(@RequestBody List<CurrentAccount> currentAccounts) {
		return (List<CurrentAccount>) getCurrentAccountService().saveAll(currentAccounts);
	}
	
	@PostMapping("/curentAccounts/{id}")
	public boolean existsById(@PathVariable int id) {
		return getCurrentAccountService().existsById(id);
	}
}
