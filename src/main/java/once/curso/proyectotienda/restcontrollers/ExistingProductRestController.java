package once.curso.proyectotienda.restcontrollers;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.model.ExistingProductModelAssembler;
import once.curso.proyectotienda.services.ExistingProductService;

@RestController
@Data
@RequestMapping("/once")
public class ExistingProductRestController {

	@Autowired
	private ExistingProductModelAssembler existingProductModelAssembler;
	
	@Autowired
	private PagedResourcesAssembler<ExistingProduct> pagedResourcesAssembler;

	@Autowired
	private final ExistingProductService existingProductService;

	/*
	 * @RequestMapping("/") public String welcomeProducts() { return
	 * "<p style='width:100%;font-size: 30px; text-align:center;'><b>Bienvenido!!!</b></p>"
	 * ; }
	 */

	/* C CREATE A PRODUCT */
	@PostMapping("/products")
	@CrossOrigin(origins ="*")
	public EntityModel<ExistingProduct> createExistingProduct(@RequestBody ExistingProduct existingProduct) {
		ExistingProduct existingProduct1 = getExistingProductService().save(existingProduct);
		existingProduct.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(SubCategoryRestController.class)
				.findById(existingProduct1.getSubcategory().getId())).withRel("subcategory"));
		existingProduct.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ExistingProductRestController.class)
				.findById(existingProduct1.getId()))
				.withSelfRel());
		return EntityModel.of(existingProduct1);
	}

	/* R READ ALL PRODUCTS */
	@GetMapping("/products")
	@CrossOrigin(origins ="*")
	public CollectionModel<ExistingProduct> getExistingProducts() {
		Iterable<ExistingProduct> existingProduct = getExistingProductService().findAll();
		existingProduct.forEach(u -> {
			u.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(SubCategoryRestController.class).findById(u.getSubcategory().getId()))
					.withRel("subcategory"));
			u.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(ExistingProductRestController.class).findById(u.getId()))
					.withSelfRel());
		});
		return CollectionModel.of(existingProduct);
	}

	/* R READ A PRODUCT */	
	@GetMapping("/products/{id}")
	@CrossOrigin(origins ="*")
	public EntityModel<ExistingProduct> findById(@PathVariable int id) {
		ExistingProduct existingProduct = getExistingProductService().findById(id).get();
		existingProduct.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(SubCategoryRestController.class)
				.findById(existingProduct.getSubcategory().getId())).withRel("subcategory"));
		existingProduct.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ExistingProductRestController.class)
				.findById(existingProduct.getId()))
				.withSelfRel());
		return EntityModel.of(existingProduct);
	}

	/* U UPDATE A PRODUCT ESTO ES PARA JBDC*/
	//@PutMapping("/products/{id}") //SPRING BOOT APP 
	// @GetMapping("/products/{id}") //Junit text
	/*@CrossOrigin(origins ="*")
	public ResponseEntity<ExistingProduct> updateExistingProduct(@PathVariable(value = "id") int existingProductId,
			@RequestBody ExistingProduct existingProductDetails) throws ResourceNotFoundException {
		ExistingProduct existingProduct = getExistingProductService().findById(existingProductId).get();
				//.orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado id :: " + existingProductId));

		existingProduct.setDescription(existingProductDetails.getDescription());
		existingProduct.setPrice(existingProductDetails.getPrice());
		existingProduct.setImage(existingProductDetails.getImage());
		existingProduct.setStock(existingProductDetails.getStock());
		existingProduct.setSubcategory(existingProductDetails.getSubcategory());

		final ExistingProduct updateExistingProduct = getExistingProductService().save(existingProduct);
		return ResponseEntity.ok(updateExistingProduct);
	}*/

	/* D DELETE A PRODUCT */
	@DeleteMapping("/products/{id}") //SPRING BOOT APP
	@CrossOrigin(origins ="*")
	//@GetMapping("/products/delete/{id}") //Junit text
	public Map<String, Boolean> deleteExistingProduct(@PathVariable(value = "id") int existingProductId)
			throws ResourceNotFoundException {
		ExistingProduct existingProduct = getExistingProductService().findById(existingProductId)
				.orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado id :: " + existingProductId));

		getExistingProductService().delete(existingProduct);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping("/productsPaginado")
	@CrossOrigin(origins ="*")
	public PagedModel<EntityModel<ExistingProduct>> findAllPaginado(@RequestParam int size, @RequestParam int page,
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
		Page<ExistingProduct> category = getExistingProductService().findAll(pageable);

		return getPagedResourcesAssembler().toModel(category, getExistingProductModelAssembler());
	}

	/* TOTAL PRODUCTS */
	@GetMapping("/products/count")
	@CrossOrigin(origins ="*")
	public long getExistingProductCount() {
		return existingProductService.count();
	}
}
