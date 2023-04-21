package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.services.ExistingProductService;
import once.curso.proyectotienda.services.SubcategoryService;

@SpringBootTest
@Data
public class ExistingProductTests {
	private String filename = "calzocillos.jpg";
	@Autowired
	private ExistingProductService existingProductService;
	@Autowired
	private SubcategoryService subcategoriesService;
	
	@Test
	public void ExistingProduct() {
		List<ExistingProduct> existingProduct = (List<ExistingProduct>) getExistingProductService().findAll();
		assertNotEquals(existingProduct.size(),0);
	}
	
	@Test
	public void findByIdExistingProduct() {
		int numID = 3;
		getExistingProductService().findById(numID).get();
	}
	
	@Test
	public void AddExistingProduct() {
		ExistingProduct existingProduct = new ExistingProduct();
		existingProduct.setDescription("WJE Herramienta en forma de botella de cerveza para hombre");
		existingProduct.setPrice(29.99);
		existingProduct.setStock(10);
		File file = new File(filename);
        byte[] imgInBytes = new byte[(int) file.length()];		
		existingProduct.setImage(imgInBytes);
			
	    existingProduct.setSubcategories(getSubcategoriesService().findById(3).get());
	
		getExistingProductService().save(existingProduct);
		
		ExistingProduct savedExistingProduct = getExistingProductService().findById(existingProduct.getId()).get();
		assertEquals(existingProduct.getId(), savedExistingProduct.getId());
	}
	
	/*@Test
	public void testFindAllProducts() {
	    List<ExistingProduct> products = (List<ExistingProduct>) getExistingProductService().findAll();
	    assertThat(products).hasSize(2);
	}*/
	
	/*@Test
	public void AddAllExistingProduct() {
		
	}*/
	
	@Test
	public void UpdExistingProduct() {
		int numID = 3;
		
		Optional<ExistingProduct> p = getExistingProductService().findById(numID);
		if (p.isPresent()) {
			ExistingProduct existingProduct = p.get();
	        existingProduct.setDescription("botella de cerveza");
			existingProduct.setPrice(2.99);
			existingProduct.setStock(10);
			File file = new File(filename);
	        byte[] imgInBytes = new byte[(int) file.length()];		
			existingProduct.setImage(imgInBytes);
		    existingProduct.setSubcategories(getSubcategoriesService().findById(3).get());
		    
		    getExistingProductService().save(existingProduct);
		}
	}
	
	@Test
	public void DelByIdExistingProduct() {
		int numID = 16;
		ExistingProduct existingProduct = getExistingProductService().findById(numID).orElse(null);
	    if (existingProduct != null) {
	    	getExistingProductService().delete(existingProduct);
	    }
	}
	
	@Test
	public void DelAllExistingProduct() {
		/*
		 NO TOQUEIS
		 
		 getExistingProductService().deleteAll();
        assertEquals(0, getExistingProductService().count());*/
	}
	
	@Test
	public void CountExistingProduct() {
		getExistingProductService().count();
	}
	
	
}