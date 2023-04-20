package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.entities.Category;
import once.curso.proyectotienda.entities.SubCategory;
import once.curso.proyectotienda.services.CategoryService;
import once.curso.proyectotienda.services.SubcategoryService;

@Data
@SpringBootTest
public class SubCategoryTests {
	
	@Autowired
	private SubcategoryService subcategoryService; 
	
	@Autowired
	private CategoryService categoryService;

	
	public void probarSaveFindDelete() {
		
		SubCategory subCategory = new SubCategory();
		
		subCategory.setDescription("pruebas de description");
		getSubcategoryService().save(subCategory);
		
		SubCategory subCategoryRecuperado = getSubcategoryService().findById(subCategory.getId()).get();
		getSubcategoryService().delete(subCategoryRecuperado);
		
		
		
		assertFalse(getSubcategoryService().existsById(subCategory.getId()));
	}
}
