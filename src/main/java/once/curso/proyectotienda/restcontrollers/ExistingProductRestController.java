package once.curso.proyectotienda.restcontrollers;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.*;
import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.entities.SubCategory;
import once.curso.proyectotienda.services.ExistingProductService;

@RestController
@Data
@RequestMapping({"/api/v1/"})
public class ExistingProductRestController {
	@Autowired
	private final ExistingProductService existingProductService;
	
	@RequestMapping("/")
    public String welcomeProducts() {
		return "<p style='width:100%;font-size: 30px; text-align:center;'><b>Bienvenido!!!</b></p>";
    }
	
	/* C CREATE A PRODUCT */
	@PostMapping("/products/create")
	public ExistingProduct createExistingProduct(@RequestBody ExistingProduct newExistingProduct) {
		return existingProductService.save(newExistingProduct);
	}

	/* R READ ALL PRODUCTS */
	@GetMapping("/products")
	public List<ExistingProduct> getExistingProducts() {
	    return (List<ExistingProduct>) existingProductService.findAll();
	}
	
	/* R READ A PRODUCT */
	@GetMapping("/products/{id}")
	public Optional<ExistingProduct> getExistingProductById(@PathVariable int id) {
		Optional<ExistingProduct> p = existingProductService.findById(id);
		if (!p.isPresent()) {
				System.err.println("El producto id " + id + " no existe.");
	            return Optional.empty();
	    }
		return getExistingProductService().findById(id);
	}
	
	/* U UPDATE A PRODUCT PRUEBA*/
	@PatchMapping("/products/update/{id}/{description}/{price}/{stock}/{subcategoriesid}")
	public ResponseEntity<ExistingProduct> updateExistingProductPartially(@PathVariable int id, @PathVariable String description, @PathVariable double price, @PathVariable int stock, @PathVariable SubCategory subcategoriesid) {
		try {
			ExistingProduct existingProduct = existingProductService.findById(id).get();
			existingProduct.setDescription(description);
			existingProduct.setPrice(price);
			existingProduct.setStock(stock);
			existingProduct.setSubcategories(subcategoriesid);
			return new ResponseEntity<ExistingProduct>(existingProductService.save(existingProduct), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/* D DELETE A PRODUCT */
	@DeleteMapping("/products/delete/{id}")
	public void deleteById(@PathVariable int id) {
		getExistingProductService().deleteById(id);
	}
	
	
	/*@GetMapping("/products/delete/{id}")
	public Object deleteById(@PathVariable int id) {
		Optional<ExistingProduct> p = existingProductService.findById(id);
		
		 if (!p.isPresent()) {
	         System.err.println("El producto id " + id + " no existe.");
	         return p;
	     }
		
		return "Se ha eliminado la fila " + getExistingProductService().deleteById(id) + " correctamente!!";
	}*/
	
	/* TOTAL PRODUCTS */
	@GetMapping("/products/count")
	public long getExistingProductCount()
	{
		System.out.println("Total de productos:: " + existingProductService.count());
		return existingProductService.count();
    }
	
	
}
	
	
	
	
	
	




































	
	
	
	
	




































/*@GetMapping("/get/{id}")
public @ResponseBody ResponseEntity<String>
getExistingProductById(@PathVariable String id) {
	return new ResponseEntity<String>("GET response ID: " + id, HttpStatus.OK);
}*/

/*@PutMapping("/products/update/{id}")
public Optional<ExistingProduct> updateById(@PathVariable int id, @Validated @RequestBody ExistingProduct existingProduct) {
	Optional<ExistingProduct> p = existingProductService.findById(id);

    if (!p.isPresent()) {
        System.err.println("El producto id " + id + " no existe.");
        return Optional.empty();
    }

    //p.get().setDescription(ExistingProduct.getDescription());
	return getExistingProductService().findById(id);
}*/
	
/*@PutMapping("/products/update/{id}")
public ResponseEntity<ExistingProduct> updateExistingProductById(@PathVariable(value = "id") int existingProductId, 
		@Validated @RequestBody ExistingProduct existingProductDetails) throws ResourceNotFoundException, IOException {
	ExistingProduct existingProduct = existingProductService.findById(existingProductId)
	.orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado el producto :: " + existingProductId));

	//existingProduct.setId(existingProductDetails.getId());
	existingProduct.setDescription(existingProductDetails.getDescription());
	existingProduct.setPrice(existingProductDetails.getPrice());
	
	//String nameImage = "calzocillos.jpg";
	
	//Path imagePath = Paths.get(nameImage);
	//if (Files.exists(imagePath)) {
	//	BufferedImage imageProduct = ImageIO.read(new File(nameImage));
	//	existingProduct.setImage(imageProduct);
	//}
	
	existingProduct.setImage(existingProductDetails.getImage());
	
	
	existingProduct.setStock(existingProductDetails.getStock());
	existingProduct.setSubcategories(existingProductDetails.getSubcategories());
	
    final ExistingProduct updatedExistingProduct = existingProductService.save(existingProduct);
    return ResponseEntity.ok(updatedExistingProduct);
*/
	
/*@DeleteMapping("/products/delete/{id}")
public Map<String, Boolean> deleteExistingProduct(@PathVariable(value = "id") int existingProductId)
  throws ResourceNotFoundException {
	ExistingProduct existingProduct = existingProductService.findById(existingProductId)
		.orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado el producto :: " + existingProductId));

	existingProductService.deleteById(existingProductId);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
}*/

/* D DELETE ALL PRODUCTS */
/*@GetMapping("/products/deleteall")
public Object deleteAll() {		
	return "Se ha eliminado todas las filas correctamente!!";
}*/
	
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

