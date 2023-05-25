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

@RestController
@RequestMapping({"/api/v1/"})
@Data
public class SoldProductRestController {

	
	@Autowired
	private SoldProductModelAssembler soldProductModelAssembler;
@Autowired
	private  PagedResourcesAssembler<SoldProduct> pagedResourcesAssembler;
	@Autowired
	private SoldProductService soldProductService;

	@PostMapping("/soldProducts")
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
	
	@GetMapping("/soldProductsPaginado")
	   public PagedModel<EntityModel<SoldProduct>> findAllPaginado(@RequestParam int size, @RequestParam int page, @RequestParam String sort){
		   StringTokenizer stringTokenizer =new StringTokenizer(sort,",");
		   Sort orden=Sort.by("a");
		   String campo=stringTokenizer.nextToken();
		   String tipoOrden= stringTokenizer.nextToken();
		   
		   if(tipoOrden.equals("asc"))
			   orden=Sort.by(campo).ascending();
		   else 
			   orden=Sort.by(campo).descending();
		   
		   Pageable pageable=PageRequest.of(page,size,orden);
		   Page<SoldProduct> category=getSoldProductService().findAll(pageable);
		   
		   return getPagedResourcesAssembler().toModel(category,getSoldProductModelAssembler());
	   }
}

/*http://localhost:8080/api/v1/soldProductsPaginado?size=2&page=0&sort=id,asc*/







