package once.curso.proyectotienda.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.entities.SoldProduct;
import once.curso.proyectotienda.services.SoldProductService;

@RestController
@RequestMapping("/api/v1")
@Data
public class SoldProductRestController {

	@Autowired
	private SoldProductService soldProductService;

	@PostMapping("/soldProducts/create")
	public SoldProduct save(@RequestBody SoldProduct soldProduct) {
		return getSoldProductService().save(soldProduct);
	}
	
	@GetMapping("/soldProducts")
	public CollectionModel<SoldProduct> getSoldProduct() {
		Iterable<SoldProduct> soldProduct = getSoldProductService().findAll();
		soldProduct.forEach(s->{
			 s.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class).findById(s.getExistingProduct().getId())).withRel("soldproduct"));
			 s.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).findById(s.getId())).withSelfRel());
		 });
		 return CollectionModel.of(soldProduct);
	}	
	
	@GetMapping("/soldProducts/{id}")
	public EntityModel<SoldProduct> findById(@PathVariable int id) {
		SoldProduct soldProduct = getSoldProductService().findById(id).get();
		soldProduct.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class).findById(soldProduct.getExistingProduct().getId())).withRel("soldproduct"));
		soldProduct.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).findById(soldProduct.getId())).withSelfRel());
		 return EntityModel.of(soldProduct);
	}

	@DeleteMapping("/soldProducts/{id}")
	public void deleteById(@PathVariable int id) {
		getSoldProductService().deleteById(id);
	}
}
