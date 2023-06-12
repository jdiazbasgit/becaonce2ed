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
import org.springframework.http.ResponseEntity;
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

import lombok.*;
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
	public ExistingProduct createExistingProduct(@RequestBody ExistingProduct newExistingProduct) {
		return getExistingProductService().save(newExistingProduct);
	}

	/* R READ ALL PRODUCTS */
	@GetMapping("/products")
	@CrossOrigin(origins ="*")
	public CollectionModel<ExistingProduct> getExistingProducts() {
		Iterable<ExistingProduct> existingProduct = getExistingProductService().findAll();
		existingProduct.forEach(u -> {
			u.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class).findById(u.getSubcategory().getId()))
					.withRel("subcategory"));
			u.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).findById(u.getId()))
					.withSelfRel());
		});
		return CollectionModel.of(existingProduct);
	}

	/* R READ A PRODUCT */
	@GetMapping("/products/{id}")
	@CrossOrigin(origins ="*")
	public EntityModel<ExistingProduct> findById(@PathVariable int id) {
		ExistingProduct existingProduct = getExistingProductService().findById(id).get();
		existingProduct.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class)
				.findById(existingProduct.getSubcategory().getId())).withRel("subcategory"));
		existingProduct.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).findById(existingProduct.getId()))
				.withSelfRel());
		return EntityModel.of(existingProduct);
	}

	/* U UPDATE A PRODUCT */
	@PutMapping("/products/update/{id}") // FUNCIONA Junit text pero NO FUNCIONA SPRING BOOT APP
	// @GetMapping("/products/update/{id}") //NO FUNCIONA Junit text pero FUNCIONA
	// SPRING BOOT APP
	@CrossOrigin(origins ="*")
	
	public ResponseEntity<ExistingProduct> updateExistingProduct(@PathVariable(value = "id") int existingProductId,
			@RequestBody ExistingProduct existingProductDetails) throws ResourceNotFoundException {
		ExistingProduct existingProduct = getExistingProductService().findById(existingProductId)
				.orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado id :: " + existingProductId));

		existingProduct.setDescription(existingProductDetails.getDescription());
		existingProduct.setPrice(existingProductDetails.getPrice());
		existingProduct.setImage(existingProductDetails.getImage());
		existingProduct.setStock(existingProductDetails.getStock());
		existingProduct.setSubcategory(existingProductDetails.getSubcategory());

		final ExistingProduct updateExistingProduct = getExistingProductService().save(existingProduct);
		return ResponseEntity.ok(updateExistingProduct);
	}

	/* D DELETE A PRODUCT */
	@DeleteMapping("/products/{id}") // FUNCIONA Junit text pero NO FUNCIONA SPRING BOOT APP
	@CrossOrigin(origins ="*")
	// @GetMapping("/products/delete/{id}") //NO FUNCIONA Junit text pero FUNCIONA
	// SPRING BOOT APP
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

/*
 * @GetMapping("/products/{id}") public Optional<ExistingProduct>
 * getExistingProductById(@PathVariable int id) { Optional<ExistingProduct> p =
 * getExistingProductService().findById(id); if (!p.isPresent()) {
 * System.err.println("El producto id " + id + " no existe."); return
 * Optional.empty(); } return getExistingProductService().findById(id); }
 */

/*
 * @DeleteMapping("/products/delete/{id}") public void deleteById(@PathVariable
 * int id) { getExistingProductService().deleteById(id); }
 */

/*
 * @GetMapping("/get/{id}") public @ResponseBody ResponseEntity<String>
 * getExistingProductById(@PathVariable String id) { return new
 * ResponseEntity<String>("GET response ID: " + id, HttpStatus.OK); }
 */

/*
 * @PutMapping("/products/update/{id}") public Optional<ExistingProduct>
 * updateById(@PathVariable int id, @Validated @RequestBody ExistingProduct
 * existingProduct) { Optional<ExistingProduct> p =
 * existingProductService.findById(id);
 * 
 * if (!p.isPresent()) { System.err.println("El producto id " + id +
 * " no existe."); return Optional.empty(); }
 * 
 * //p.get().setDescription(ExistingProduct.getDescription()); return
 * getExistingProductService().findById(id); }
 */

/*
 * @DeleteMapping("/products/delete/{id}") public Map<String, Boolean>
 * deleteExistingProduct(@PathVariable(value = "id") int existingProductId)
 * throws ResourceNotFoundException { ExistingProduct existingProduct =
 * existingProductService.findById(existingProductId) .orElseThrow(() -> new
 * ResourceNotFoundException("No se ha encontrado el producto :: " +
 * existingProductId));
 * 
 * existingProductService.deleteById(existingProductId); Map<String, Boolean>
 * response = new HashMap<>(); response.put("deleted", Boolean.TRUE); return
 * response; }
 */

/* D DELETE ALL PRODUCTS */
/*
 * @GetMapping("/products/deleteall") public Object deleteAll() { return
 * "Se ha eliminado todas las filas correctamente!!"; }
 */

/*
 * @RequestMapping({ "/productList" }) public String listProductHandler(Model
 * model, //
 * 
 * @RequestParam(value = "name", defaultValue = "") String likeName,
 * 
 * @RequestParam(value = "page", defaultValue = "1") int page) { final int
 * maxResult = 5; final int maxNavigationPage = 10;
 * 
 * PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
 * maxResult, maxNavigationPage, likeName);
 * 
 * model.addAttribute("paginationProducts", result); return "productList"; }
 */

/*
 * @GetMapping("/products") List<ExistingProducts> all() { return
 * getExistingproductsCRUDRepository().findAll(); }
 * 
 * @PostMapping("/products") ExistingProducts newExistingProducts(@RequestBody
 * ExistingProducts newExistingProducts) { return
 * existingproductsCRUDRepository.save(newExistingProducts); }
 */

/*
 * @PutMapping("/products/{id}") ExistingProducts
 * replaceExistingProducts(@RequestBody ExistingProducts
 * newExistingProducts, @PathVariable Long id) {
 * 
 * return existingproductsCRUDRepository.findById(id) .map(existingproducts -> {
 * existingproducts.setName(newEmployee.getName());
 * existingproducts.setRole(newEmployee.getRole()); return
 * repository.save(existingproducts); }) .orElseGet(() -> {
 * newExistingProducts.setId(id); return repository.save(newExistingProducts);
 * }); }
 */

/*
 * @GetMapping(
 * "/products/update/{id}/{description}/{price}/{stock}/{subcategoriesid}")
 * public ResponseEntity<ExistingProduct>
 * updateExistingProductPartially(@PathVariable int id, @PathVariable String
 * description, @PathVariable double price, @PathVariable int
 * stock, @PathVariable SubCategory subcategoriesid) { ExistingProduct
 * existingProduct = existingProductService.findById(id) .orElseThrow(() -> new
 * ResourceNotFoundException("No se ha encontrado id:: " + id));
 * existingProduct.setDescription(description); existingProduct.setPrice(price);
 * existingProduct.setStock(stock);
 * existingProduct.setSubcategories(subcategoriesid);
 * existingProductService.save(existingProduct); return
 * ResponseEntity.ok(existingProduct); }
 */
