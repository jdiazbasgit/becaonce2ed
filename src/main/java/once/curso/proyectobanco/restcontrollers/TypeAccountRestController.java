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
import once.curso.proyectobanco.entities.TypeAccount;
import once.curso.proyectobanco.models.TypeAccountModelAssembler;
import once.curso.proyectobanco.services.TypeAccountService;

@RestController
@Data
@RequestMapping("/once")
public class TypeAccountRestController {

	@Autowired
	private TypeAccountService typeAccountService;

	@Autowired
	private TypeAccountModelAssembler typeAccountModelAssembler;

	@Autowired
	private PagedResourcesAssembler<TypeAccount> pagedResourcesAssembler;

	@GetMapping(value = "/typeAccounts/{id}")
	public EntityModel<TypeAccount> findById(@PathVariable int id) {
		TypeAccount typeAccount = getTypeAccountService().findById(id).get();
		typeAccount.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(TypeAccountRestController.class).findById(typeAccount.getId()))
				.withSelfRel());
		return EntityModel.of(typeAccount);
	}

	/*
	 * @GetMapping(value = "/typeAccounts") public CollectionModel<TypeAccount>
	 * findAll() { Iterable<TypeAccount>
	 * typeAccount=getTypeAccountService().findAll(); typeAccount.forEach(t->{
	 * t.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
	 * TypeAccountRestController.class). findAll()).withSelfRel()); }); return
	 * CollectionModel.of(typeAccount); }
	 */

	@GetMapping(value = "/typeAccounts")

	public PagedModel<EntityModel<TypeAccount>> findAll(@RequestParam(defaultValue = "0") int size,
			@RequestParam(defaultValue = "0") int page, @RequestParam(required = false) String sort) {
		if (size == 0) {
			size = (int) getTypeAccountService().count();
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
		Page<TypeAccount> typeAccount = getTypeAccountService().findAll(pageable);
		return getPagedResourcesAssembler().toModel(typeAccount, getTypeAccountModelAssembler());

	}

	@PostMapping(value = "/typeAccounts")
	public TypeAccount save(@RequestBody TypeAccount typeAccount) {
		return getTypeAccountService().save(typeAccount);
	}

	@PutMapping(value = "/typeAccounts")
	public List<TypeAccount> saveAll(@RequestBody List<TypeAccount> typeAccount) {
		return (List<TypeAccount>) getTypeAccountService().saveAll(typeAccount);
	}

	@DeleteMapping(value = "typeAccounts/{id}")
	public void deleteById(@PathVariable Integer id) {
		getTypeAccountService().deleteById(id);
	}
}
