package once.curso.proyectotienda;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.entities.Category;
import once.curso.proyectotienda.services.CategoryService;

@SpringBootTest
@Data
public class CategoryTest {

	@Autowired
	private CategoryService categoryService;

	@Test
	public void findAll() {
		List<Category> category = (List<Category>) getCategoryService().findAll();
		assertNotEquals(category.size(), 0);
	}

	@Test
	public void probarSaveFindDelete() {
		Category category = new Category();
		category.setDescription("prueba");
		getCategoryService().save(category);
		Category categoryRecuperado = getCategoryService().findById(category.getId()).get();
		getCategoryService().delete(categoryRecuperado);
		Category categoryBorrado = getCategoryService().findById(category.getId()).get();
		assertNull(categoryBorrado);
	}
}
