package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
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
		
	@Test
	public void AddExistingProduct() {
		SubcategoryService subcategoriesService = new SubcategoryService();
		
		ExistingProduct existingProduct = new ExistingProduct();
		existingProduct.setDescription("Bragas para niña Paquete de 12 algodón Calzoncillos para Niñas (2-9 años)");
		existingProduct.setPrice(20.70);
		existingProduct.setStock(10);
		File file = new File(filename);
        byte[] picInBytes = new byte[(int) file.length()];		
		existingProduct.setImage(picInBytes);
			
	    existingProduct.setSubcategories(subcategoriesService.findById(3).get());
	
		existingProductService.save(existingProduct);
		
		ExistingProduct savedExistingProduct = existingProductService.findById(existingProduct.getId()).orElse(null);
		assertEquals(existingProduct, savedExistingProduct);
	}	
}