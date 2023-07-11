package once.curso.proyectotienda.restcontrollers;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.SoldProduct;
import once.curso.proyectotienda.model.SoldProductModelAssembler;
import once.curso.proyectotienda.services.SoldProductService;

@Data
@RequestMapping("/once")
@RestController
public class SoldProductRestController {

	@Autowired
	private SoldProductService soldProductService;

	@Autowired
	private  PagedResourcesAssembler<SoldProduct> pagedResourcesAssembler;
	
	@Autowired
	private SoldProductModelAssembler soldProductModelAssembler;

	@GetMapping("/soldProducts")
	@CrossOrigin(origins = "*")
	public CollectionModel<SoldProduct> findAll() {
		Iterable<SoldProduct> soldProduct = getSoldProductService().findAll();
		soldProduct.forEach(s -> {
			 s.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class).findById(s.getProfile().getId())).withRel("profile"));
			 s.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExistingProductRestController.class).findById(s.getExistingProduct().getId())).withRel("existingProduct"));
			 s.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SoldProductRestController.class).findById(s.getId())).withSelfRel());
		});
		return CollectionModel.of(soldProduct);
	}

	@GetMapping(value = "/soldProducts/{id}")
	@CrossOrigin(origins = "*")
	public EntityModel<SoldProduct> findById(@PathVariable int id) {
		SoldProduct soldProducts = getSoldProductService().findById(id).get();
		soldProducts.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class).findById(soldProducts.getProfile().getId())).withRel("profile"));
		soldProducts.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExistingProductRestController.class).findById(soldProducts.getExistingProduct().getId())).withRel("existingProduct"));
		soldProducts.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SoldProductRestController.class).findById(soldProducts.getId())).withSelfRel());

		return EntityModel.of(soldProducts);
	}
	
	@GetMapping("/soldProductsPaginado")
	@CrossOrigin(origins = "*")
	public PagedModel<EntityModel<SoldProduct>> findAllPaginado(@RequestParam int size, @RequestParam int page,
			@RequestParam String sort) {
		StringTokenizer stringTokenizer = new StringTokenizer(sort, ",");
		Sort orden = Sort.by("a");
		String campo = stringTokenizer.nextToken();
		String tipoOrden = stringTokenizer.nextToken();

		if (tipoOrden.equals("asc"))
			orden = Sort.by(campo).ascending();
		else
			orden = Sort.by(campo).descending();

		Pageable pageable = PageRequest.of(page, size, orden);
		Page<SoldProduct> soldProduct = getSoldProductService().findAll(pageable);

		return getPagedResourcesAssembler().toModel(soldProduct, getSoldProductModelAssembler());
	}
	/*
	 http://localhost:8080/once/soldProductsPaginado?size=2&page=0&sort=id,asc
	*/

	@PostMapping("/soldProducts")
	@CrossOrigin(origins ="*")
	public EntityModel<SoldProduct> createSoldProducts(@RequestBody SoldProduct soldProduct) {
		SoldProduct soldProduct1 = getSoldProductService().save(soldProduct);
		soldProduct1.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class).findById(soldProduct1.getProfile().getId())).withRel("profile"));
		soldProduct1.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExistingProductRestController.class).findById(soldProduct1.getExistingProduct().getId())).withRel("existingProduct"));
		soldProduct1.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SoldProductRestController.class).findById(soldProduct1.getId())).withSelfRel());

		return EntityModel.of(soldProduct1);
	}

	
	@DeleteMapping("/soldProducts/{id}")
	@CrossOrigin(origins = "*")
	public boolean deleteById(@PathVariable int id) {
		try {
			getSoldProductService().deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

 	@PostMapping("/soldProducts/{id}")
	@CrossOrigin(origins = "*")
	public boolean existById(@PathVariable int id) {
		return getSoldProductService().existsById(id);
	}

	@GetMapping("/soldProducts/count")
	@CrossOrigin(origins = "*")
	public long getSoldProductCount() {
		return soldProductService.count();
    }
	
}
