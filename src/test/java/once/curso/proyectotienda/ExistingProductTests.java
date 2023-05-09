package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
public class ExistingProductTests{
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
	public void existsByIdExistingProduct() {
		int numID = 3;
		if (getExistingProductService().existsById(numID)==true){
			/*bla bla*/
		}
	}
	
	@Test
	public void AddExistingProduct() {
		ExistingProduct existingProduct = new ExistingProduct();
		existingProduct.setDescription("New World");
		existingProduct.setPrice(74.99);
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
	public void DelAllByIdExistingProduct() {
		/*
		NO TOQUEIS
		List<ExistingProduct> existingProduct = (List<ExistingProduct>) getExistingProductService().findAll();
		List<Integer> idsToDelete =new ArrayList<>();
		idsToDelete.add(existingProduct.get(3).getId());
		idsToDelete.add(existingProduct.get(4).getId());
		
		getExistingProductService().deleteAllById(idsToDelete);*/
	}
	
	public void delExistingProduct(ExistingProduct entity) {
		//getExistingProductsCRUDRepository().delete(entity);
	}
	
	@Test
	public void CountExistingProduct() {
		getExistingProductService().count();
	}
	
	@Test
	public void DelAllentitiesExistingProduct() {
		/*
		NO TOQUEIS
		
		List<ExistingProduct> existingProduct = (List<ExistingProduct>) getExistingProductService().findAll();
		List<ExistingProduct> objectToDelete =new ArrayList<ExistingProduct>();
		objectToDelete.add(existingProduct.get(3));
		objectToDelete.add(existingProduct.get(4));
		
		getExistingProductService().deleteAll(objectToDelete);*/
	}
	
	@Test
	public void DelAllExistingProduct() {
		/*
		 NO TOQUEIS
		 
		 getExistingProductService().deleteAll();
        assertEquals(0, getExistingProductService().count());*/
	}
}