package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.entities.Category;
import once.curso.proyectotienda.repositories.CardTypeCRUDRepository;
import once.curso.proyectotienda.services.CategoryService;

@SpringBootTest
@Data
@TestMethodOrder(value = OrderAnnotation.class)
public class CategoryTest {

	@Autowired
	private CardTypeCRUDRepository cardTypeCRUDRepository;
	
	@Autowired
	private CategoryService categoryService;

	@Test
	@Order(1)
	public void findAll() {
		List<Category> category = (List<Category>) getCategoryService().findAll();
		assertNotEquals(category.size(), 0);
	}

	@Test
	@Order(2)
	public void probarSaveFindDelete() {
		Category category = new Category();
		category.setDescription("pruebac");
		getCategoryService().save(category);
		Category categoryRecuperado = getCategoryService().findById(category.getId()).get();
		getCategoryService().delete(categoryRecuperado);

		assertFalse(getCategoryService().existsById(category.getId()));

	}

	@Test
	@Order(3)
	public void probarSaveAllDeleteAllById() {
		Long cantidadAlEmpezar = getCategoryService().count();
		List<Category> categories = new ArrayList<Category>();
		Category categoryPrueba1 = new Category();
		categoryPrueba1.setDescription("pruebaA");
		categories.add(categoryPrueba1);

		Category categoryPrueba2 = new Category();
		categoryPrueba2.setDescription("pruebaB");
		categories.add(categoryPrueba2);

		getCategoryService().saveAll(categories);
		assertEquals(getCategoryService().count(), cantidadAlEmpezar + 2);

		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(categoryPrueba1.getId());
		numeros.add(categoryPrueba2.getId());

		categoryService.deleteAllById(numeros);

		assertEquals(cantidadAlEmpezar, getCategoryService().count());

	}

	@Test
	@Order(4)
	public void probarFindByIdAndDeleteById() {
		List<Category> categories = new ArrayList<Category>();
		Category categoryPrueba1 = new Category();
		categoryPrueba1.setDescription("pruebaA");
		categories.add(categoryPrueba1);
		categoryService.saveAll(categories);

		Optional<Category> resultado = categoryService.findById(categoryPrueba1.getId());
		assertTrue(resultado.isPresent());
		assertTrue(resultado.get().getDescription().equals("pruebaA"));

		categoryService.deleteById(categoryPrueba1.getId());
		Optional<Category> resultadoDespues = categoryService.findById(categoryPrueba1.getId());
		assertFalse(resultadoDespues.isPresent());
	}

	@Test
	@Order(5)
	public void probarCount() {
		List<Category> categories = new ArrayList<Category>();
		Category categoryPrueba1 = new Category();
		Category categoryPrueba2 = new Category();
		Category categoryPrueba3 = new Category();
		categoryPrueba1.setDescription("pruebaA");
		categoryPrueba2.setDescription("pruebaB");
		categoryPrueba3.setDescription("pruebaC");
		categories.add(categoryPrueba1);
		categories.add(categoryPrueba2);
		categories.add(categoryPrueba3);
		categoryService.saveAll(categories);

		long cantidad = categoryService.count();
		assertEquals(6, cantidad);

		categories.forEach(category -> categoryService.deleteById(category.getId()));
	}

	@Test
	@Order(6)
	public void probarExistById() {
		List<Category> categories = new ArrayList<Category>();
		Category categoryPrueba1 = new Category();
		categoryPrueba1.setDescription("pruebaA");
		categories.add(categoryPrueba1);
		categoryService.saveAll(categories);

		assertTrue(categoryService.existsById(categoryPrueba1.getId()));

		categoryService.delete(categoryPrueba1);
	}

	@Test
	@Order(7)
	public void probarFindAll() {
		List<Category> categories = new ArrayList<>();
		Category category1 = new Category();
		category1.setDescription("PruebaA");
		categories.add(category1);
		Category category2 = new Category();
		category2.setDescription("PruebaB");
		categories.add(category2);
		categoryService.saveAll(categories);

		List<Category> allCategories = (List<Category>) categoryService.findAll();
		assertEquals(5, allCategories.size());
		assertTrue(allCategories.contains(category1));
		assertTrue(allCategories.contains(category2));

		categories.forEach(category -> categoryService.deleteById(category.getId()));
	}

	@Test
	@Order(8)
	public void probarFindAllById() {
	    List<Category> categories = new ArrayList<Category>();
	    Category categoryPrueba1 = new Category();
	    Category categoryPrueba2 = new Category();
	    Category categoryPrueba3 = new Category();
	    categoryPrueba1.setDescription("pruebaA");
	    categoryPrueba2.setDescription("pruebaB");
	    categoryPrueba3.setDescription("pruebaC");
	    categories.add(categoryPrueba1);
	    categories.add(categoryPrueba2);
	    categories.add(categoryPrueba3);
	    categoryService.saveAll(categories);

	    List<Category> categoriesById = new ArrayList<Category>();
	    categoriesById.add(categoryService.findById(categoryPrueba1.getId()).orElse(null));
	    categoriesById.add(categoryService.findById(categoryPrueba2.getId()).orElse(null));
	    categoriesById.add(categoryService.findById(categoryPrueba3.getId()).orElse(null));

	    assertEquals(3, categoriesById.size());
	    assertEquals(categoryPrueba1.getDescription(), categoriesById.get(0).getDescription());
	    assertEquals(categoryPrueba2.getDescription(), categoriesById.get(1).getDescription());
	    assertEquals(categoryPrueba3.getDescription(), categoriesById.get(2).getDescription());
	   
	    categories.forEach(category -> categoryService.deleteById(category.getId()));
	}
	
	@Test
	@Order(9)
	public void probarSaveAndRestoreTableData() {
	    List<Category> categoriesAnteriores = (List<Category>) categoryService.findAll();
	    
	    List<Category> categoriesNuevos = new ArrayList<Category>();
	    Category categoryPrueba1 = new Category();
	    categoryPrueba1.setDescription("pruebaAA");
	    categoriesNuevos.add(categoryPrueba1);
	    categoryService.saveAll(categoriesNuevos);
	    
	    categoryService.deleteAll();
	    
	    List<Category> categoriesVacios = (List<Category>) categoryService.findAll();
	    assertTrue(categoriesVacios.isEmpty());
	    
	    categoryService.saveAll(categoriesAnteriores);
	    
	    List<Category> categoriesRestaurados = (List<Category>) categoryService.findAll();
	    assertFalse(categoriesRestaurados.isEmpty());
	    assertEquals(categoriesAnteriores.size(), categoriesRestaurados.size());
	}
}
