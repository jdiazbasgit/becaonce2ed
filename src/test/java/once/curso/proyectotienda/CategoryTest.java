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


import once.curso.proyectotienda.services.SoldProductService;
import lombok.Data;
import once.curso.proyectotienda.entities.Category;
import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.entities.SoldProduct;
import once.curso.proyectotienda.entities.SubCategory;
import once.curso.proyectotienda.repositories.CardTypeCRUDRepository;
import once.curso.proyectotienda.repositories.CategoryCRUDRepository;
import once.curso.proyectotienda.repositories.ExistingProductCRUDRepository;
import once.curso.proyectotienda.repositories.SoldProductCRUDRepository;
import once.curso.proyectotienda.repositories.SubCategoryCRUDRepository;
import once.curso.proyectotienda.services.CategoryService;
import once.curso.proyectotienda.services.ExistingProductService;
import once.curso.proyectotienda.services.SubCategoryService;

@SpringBootTest
@Data
@TestMethodOrder(value = OrderAnnotation.class)
public class CategoryTest {

	@Autowired
	private CategoryCRUDRepository categoryCRUDRepository;
	
	
	@Autowired
	private SubCategoryCRUDRepository subCategoryCRUDRepository;
	
	
	@Autowired
	private ExistingProductCRUDRepository existingProductCRUDRepository;
	
	
	@Autowired
	private SoldProductCRUDRepository soldProductCRUDRepository;
	
	
	@Autowired
	private CategoryService categoryService;
	
	
	@Autowired
	private SubCategoryService subcategoryService;
	
	
	@Autowired
	private ExistingProductService existingProductService;
	
	
	@Autowired
	private SoldProductService soldProductService;

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

		Optional<Category> resultado = getCategoryService().findById(categoryPrueba1.getId());
		assertTrue(resultado.isPresent());
		assertTrue(resultado.get().getDescription().equals("pruebaA"));

		categoryService.deleteById(categoryPrueba1.getId());
		Optional<Category> resultadoDespues = getCategoryService().findById(categoryPrueba1.getId());
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
		getCategoryService().saveAll(categories);

		long cantidad = getCategoryService().count();
		assertEquals(12, cantidad);

		categories.forEach(category -> getCategoryService().deleteById(category.getId()));
	}

	@Test
	@Order(6)
	public void probarExistById() {
		List<Category> categories = new ArrayList<Category>();
		Category categoryPrueba1 = new Category();
		categoryPrueba1.setDescription("pruebaA");
		categories.add(categoryPrueba1);
		getCategoryService().saveAll(categories);

		assertTrue(getCategoryService().existsById(categoryPrueba1.getId()));

		getCategoryService().delete(categoryPrueba1);
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
		getCategoryService().saveAll(categories);

		List<Category> allCategories = (List<Category>) getCategoryService().findAll();
		assertEquals(11, allCategories.size());
		assertTrue(allCategories.contains(category1));
		assertTrue(allCategories.contains(category2));

		categories.forEach(category -> getCategoryService().deleteById(category.getId()));
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
	    getCategoryService().saveAll(categories);

	    List<Category> categoriesById = new ArrayList<Category>();
	    categoriesById.add(getCategoryService().findById(categoryPrueba1.getId()).orElse(null));
	    categoriesById.add(getCategoryService().findById(categoryPrueba2.getId()).orElse(null));
	    categoriesById.add(getCategoryService().findById(categoryPrueba3.getId()).orElse(null));

	    assertEquals(3, categoriesById.size());
	    assertEquals(categoryPrueba1.getDescription(), categoriesById.get(0).getDescription());
	    assertEquals(categoryPrueba2.getDescription(), categoriesById.get(1).getDescription());
	    assertEquals(categoryPrueba3.getDescription(), categoriesById.get(2).getDescription());
	   
	    categories.forEach(category -> getCategoryService().deleteById(category.getId()));
	}
	
	/*@Test
	@Order(9)
	public void probarSaveAndRestoreTableData() {
	    List<Category> categoriesAnteriores = (List<Category>) getCategoryService().findAll();
	    List<SubCategory> subCategoriesAnteriores = (List<SubCategory>) getSubcategoryService().findAll(); 
	    List<ExistingProduct> existingProductsAnteriores = (List<ExistingProduct>) getExistingProductService().findAll();
	    List<SoldProduct> soldProductsAnteriores = (List<SoldProduct>) getSoldProductService().findAll();
	    
	    
	    List<Category> categoriesNuevos = new ArrayList<Category>();
	    Category categoryPrueba1 = new Category();
	    categoryPrueba1.setDescription("pruebaAA");
	    categoriesNuevos.add(categoryPrueba1);
	    getCategoryService().saveAll(categoriesNuevos);
	    
	    List<SubCategory> subCategoriesNuevos = new ArrayList<SubCategory>();
	    SubCategory subCategoryPrueba1 = new SubCategory();
	    subCategoryPrueba1.setDescription("pruebaBB");
	    subCategoryPrueba1.setCategory(categoryPrueba1);
	    subCategoriesNuevos.add(subCategoryPrueba1);
	    getSubcategoryService().saveAll(subCategoriesNuevos);
	    
	    List<ExistingProduct> existingProductsNuevos = new ArrayList<ExistingProduct>();
	    ExistingProduct existingProductPrueba1 = new ExistingProduct();
	    existingProductPrueba1.setDescription("pruebaCC");
	    existingProductPrueba1.setPrice(10.00);
	    existingProductPrueba1.setImage("pruebaCC");
	    existingProductPrueba1.setSubcategories(subCategoryPrueba1); 
	    existingProductsNuevos.add(existingProductPrueba1);
	    getExistingProductService().saveAll(existingProductsNuevos);
	    
	    List<SoldProduct> soldProductsNuevos = new ArrayList<SoldProduct>();
	    SoldProduct soldProductPrueba1 = new SoldProduct();
	    soldProductPrueba1.setQuantity(77);
	    soldProductPrueba1.setExistingProduct(existingProductPrueba1);
	    soldProductsNuevos.add(soldProductPrueba1);
	    getSoldProductService().saveAll(soldProductsNuevos);
	    
	    
	    getCategoryService().deleteAll();
	    getSubcategoryService().deleteAll();
	    getExistingProductService().deleteAll();
	    getSoldProductService().deleteAll();
	    
	    
	    List<Category> categoriesVacios = (List<Category>) getCategoryService().findAll();
	    assertTrue(categoriesVacios.isEmpty());  
	    List<SubCategory> subCategoriesVacios = (List<SubCategory>) getSubcategoryService().findAll();
	    assertTrue(subCategoriesVacios.isEmpty());
	    List<ExistingProduct> existingProductsVacios = (List<ExistingProduct>) getExistingProductService().findAll();
	    assertTrue(existingProductsVacios.isEmpty());
	    List<SoldProduct> soldProductsVacios = (List<SoldProduct>) getSoldProductService().findAll();
	    assertTrue(soldProductsVacios.isEmpty());
	    
	    
	    getCategoryService().saveAll(categoriesAnteriores);
	    getSubcategoryService().saveAll(subCategoriesAnteriores);
	    getExistingProductService().saveAll(existingProductsAnteriores);
	    getSoldProductService().saveAll(soldProductsAnteriores);
	    
	    
	    List<Category> categoriesRestaurados = (List<Category>) getCategoryService().findAll();
	    assertFalse(categoriesRestaurados.isEmpty());
	    assertEquals(categoriesAnteriores.size(), categoriesRestaurados.size());
	    
	    List<SubCategory> subCategoriesRestaurados = (List<SubCategory>) getSubcategoryService().findAll();
	    assertFalse(subCategoriesRestaurados.isEmpty());
	    assertEquals(subCategoriesAnteriores.size(), subCategoriesRestaurados.size());
	    
	    List<ExistingProduct> existingProductsRestaurados = (List<ExistingProduct>) getExistingProductService().findAll();
	    assertFalse(existingProductsRestaurados.isEmpty());
	    assertEquals(existingProductsAnteriores.size(), existingProductsRestaurados.size());
	    
	    List<SoldProduct> soldProductsRestaurados = (List<SoldProduct>) getSoldProductService().findAll();
	    assertFalse(soldProductsRestaurados.isEmpty());
	    assertEquals(soldProductsAnteriores.size(), soldProductsRestaurados.size());
	}*/
}
