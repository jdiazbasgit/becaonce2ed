package once.curso.proyectotienda.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.*;
import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.services.ExistingProductService;

@RestController
@Data
//@RequestMapping({"/api/v1/products"})
public class ExistingProductRestController {
	
	@Autowired
	private final ExistingProductService existingProductService;

	/*ProductRestController(ExistingProductCRUDRepository existingProductsCRUDRepository) {
		this.existingProductService = existingProductService;
	}*/
	
	@GetMapping("/products")
	public List<ExistingProduct> getProducts() {
	    return (List<ExistingProduct>) existingProductService.findAll();
	}

	@DeleteMapping("/products/delete/{id}")
	public void deleteById(@PathVariable int id) {
		getExistingProductService().deleteById(id);
	}
	
	//@PutMapping(value="/products/update/{id}")
    //public void update(@PathVariable long id, @Validated @RequestBody ExistingProduct existingProduct) {

        /*Optional<Product> p = existingProductService.findById(id);

        if (!p.isPresent()) {
            log.error("Producto id " + id + " no existe.");
            return ResponseEntity.notFound().build();
        }

        p.get().setName(product.getName());
        p.get().setPrice(product.getPrice());
        p.get().setDescription(product.getDescription());

        return ResponseEntity.ok(productService.createOrUpdate(p.get()));*/
    //}
}
	
	
	
	
	
	




































	
	
	
	
	
	
	
	
	
	
	/*@RequestMapping({ "/productList" })
	public String listProductHandler(Model model, //
	 @RequestParam(value = "name", defaultValue = "") String likeName,
	 @RequestParam(value = "page", defaultValue = "1") int page) {
	  final int maxResult = 5;
	  final int maxNavigationPage = 10;

	  PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
	            maxResult, maxNavigationPage, likeName);

	      model.addAttribute("paginationProducts", result);
	      return "productList";
	}*/
	  
	/*@GetMapping("/products")
	List<ExistingProducts> all() {
	    return getExistingproductsCRUDRepository().findAll();
	}
	
	@PostMapping("/products")
	ExistingProducts newExistingProducts(@RequestBody ExistingProducts newExistingProducts) {
	    return existingproductsCRUDRepository.save(newExistingProducts);
	}*/
	
	/*@PutMapping("/products/{id}")
	ExistingProducts replaceExistingProducts(@RequestBody ExistingProducts newExistingProducts, @PathVariable Long id) {
	    
	   return existingproductsCRUDRepository.findById(id)
	      .map(existingproducts -> {
	    	  existingproducts.setName(newEmployee.getName());
	    	  existingproducts.setRole(newEmployee.getRole());
	        return repository.save(existingproducts);
	      })
	      .orElseGet(() -> {
	        newExistingProducts.setId(id);
	        return repository.save(newExistingProducts);
	      });
	  }*/

