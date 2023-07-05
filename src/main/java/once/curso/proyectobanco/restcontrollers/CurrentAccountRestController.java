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
import once.curso.proyectobanco.beans.UserName;
import once.curso.proyectobanco.entities.CurrentAccount;
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
	private PagedResourcesAssembler<CurrentAccount> pagedResourcesAssembler;

	@GetMapping(value = "/currentsAccounts/{id}")
    public EntityModel<CurrentAccount> findById(@PathVariable Integer id) {
        CurrentAccount currentAccount = getCurrentAccountService().findById(id).get();
        currentAccount.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FeeRestController.class)
				  .findById(currentAccount.getFee().getId())).withRel("fee"));
		currentAccount.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TypeAccountRestController.class)
				  .findById(currentAccount.getTypeAccount().getId())).withRel("typeAccount"));
		currentAccount.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class)
				  .findById(currentAccount.getUser().getId())).withRel("user"));
        currentAccount.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class)
                .findById(currentAccount.getId())).withSelfRel());
        return EntityModel.of(currentAccount);
	}
	
	@PatchMapping(value = "/currentsAccounts")
	public List<CurrentAccount> getCurrentAccountsByUser( @RequestBody UserName  userName){
	return getCurrentAccountService().getCurrentAccountsByUser(userName.getUserName());	
	}
        
	@GetMapping(value = "/currentsAccounts")
    public PagedModel<EntityModel<CurrentAccount>> findAll(@RequestParam (defaultValue="0")int size,@RequestParam (defaultValue="0")int page,@RequestParam (required=false)String sort){
//    	StringTokenizer stringTokenizer = new StringTokenizer(sort,",");
//    	Sort orden = Sort.by("a");
//    	
//    	String campo = stringTokenizer.nextToken();
//    	String tipoOrden = stringTokenizer.nextToken();
//    	
//    	if(tipoOrden.contentEquals("asc"))
//    		orden = Sort.by(campo).ascending();
//    	else
//    		orden = Sort.by(campo).descending();
		
		if (size == 0) {
			size = (int) getCurrentAccountService().count();
		}
		Sort orden = Sort.by("id");	
		if (sort != null) {
			orden = Sort.by(sort);
			StringTokenizer stringTokenizer = new StringTokenizer(sort,",");
			String campo = stringTokenizer.nextToken();
			String tipoOrden = stringTokenizer.nextToken();
			if (tipoOrden.contentEquals("asc")) {
				orden = Sort.by(campo).ascending();
			}
			else {
				orden = Sort.by(campo).descending();
			}
		}
    	
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
	
	@PostMapping(value = "/currentsAccounts")
	public boolean save(@RequestBody CurrentAccount currentAccount) {
		return getCurrentAccountService().existsById(getCurrentAccountService().save(currentAccount).getId());
	}

	@DeleteMapping(value = "/currentsAccounts/{id}")
	public boolean deleteById(@PathVariable Integer id) {
		getCurrentAccountService().deleteById(id);
		return getCurrentAccountService().existsById(id);
	}
	
	@PutMapping("/currentsAccounts")
	public List <CurrentAccount> saveAll(@RequestBody List<CurrentAccount> currentAccounts) {
		return (List<CurrentAccount>) getCurrentAccountService().saveAll(currentAccounts);
	}
	
	@PostMapping("/currentsAccounts/{id}")
	public boolean existsById(@PathVariable int id) {
		return getCurrentAccountService().existsById(id);
	}
}
