package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.entities.SubCategory;
import once.curso.proyectotienda.services.CategoryService;
import once.curso.proyectotienda.services.SubCategoryService;

@Data
@SpringBootTest
public class SubCategoryTests {
	
	@Autowired
	private SubCategoryService subcategoryService; 
	
	@Autowired
	private CategoryService categoryService;
	
	@Order(1)
	@Test
	public void findAll() {

		List<SubCategory> subCategories = (List<SubCategory>) getSubcategoryService().findAll();
		assertNotEquals(subCategories.size(), 0);
	}
	
	@Order(2)
	@Test
	public void probarSaveFindDelete() {
		
		SubCategory subCategory = new SubCategory();
		subCategory.setDescription("pruebabababa");
		subCategory.setCategory(getCategoryService().findById(398).get());
		getSubcategoryService().save(subCategory);
		//SubCategory subcategoryRecuperado = getSubcategoryService().findById(subCategory.getId()).get();
		//getSubcategoryService().delete(subcategoryRecuperado);
		getSubcategoryService().deleteById(subCategory.getId());		
		assertFalse(getSubcategoryService().existsById(subCategory.getId()));
		/* {
			Category category = new Category();
			category.setDescription("pruebac");
			getCategoryService().save(category);
			Category categoryRecuperado = getCategoryService().findById(category.getId()).get();
			getCategoryService().delete(categoryRecuperado);

			assertFalse(getCategoryService().existsById(category.getId()));*/
	}
	
	public void findAllById() {
		
		List<SubCategory> subCategories = new ArrayList<SubCategory>();
		
		SubCategory pruebas = new SubCategory();
		SubCategory pruebas2 = new SubCategory();
		SubCategory pruebas3 = new SubCategory();
		
		pruebas.setDescription("prueba1");
		pruebas2.setDescription("pruebas 2");
		pruebas3.setDescription("pruebas 3");
		
		subCategories.add(pruebas);
		subCategories.add(pruebas2);
		subCategories.add(pruebas3);
		
		subcategoryService.saveAll(subCategories);
		
		
		
		
	}
	@Order(3)
	@Test
	public void count() {
		
		List<SubCategory> subCategories = new ArrayList<SubCategory>();
		
		SubCategory prueba1 = new SubCategory();
		prueba1.setDescription("prueba 1");
		prueba1.setCategory(getCategoryService().findById(398).get());
		subCategories.add(prueba1);
				
		SubCategory prueba2 = new SubCategory();
		prueba2.setDescription("prueba 2");
		prueba2.setCategory(getCategoryService().findById(398).get());
		subCategories.add(prueba2);
		long cantidadAntes = subcategoryService.count();
		subcategoryService.saveAll(subCategories);
		
		
		long cantidad = subcategoryService.count();
		assertEquals(cantidadAntes +2, cantidad);
		
		subCategories.forEach(subCategory -> subcategoryService.deleteById(subCategory.getId()));
	}
	
	public void existByid() {
		List<SubCategory> subCategories = new ArrayList<SubCategory>();
		
		SubCategory sCategoryp= new SubCategory();
		sCategoryp.setDescription("probando existById");
		
		subCategories.add(sCategoryp);
		subcategoryService.saveAll(subCategories);
		
		assertTrue(subcategoryService.existsById(sCategoryp.getId()));
		
		subcategoryService.delete(sCategoryp);
		//ronald
	}
}
