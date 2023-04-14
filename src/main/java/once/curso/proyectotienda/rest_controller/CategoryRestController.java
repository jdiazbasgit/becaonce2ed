package once.curso.proyectotienda.rest_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entity.Category;
import once.curso.proyectotienda.services.CategoryService;

@RestController
@RequestMapping("/once")
@Data
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/categories")
	public Category save(@RequestBody Category category) {
		return getCategoryService().save(category);
	}

	@GetMapping("/categories")
	public Iterable<Category> findAll() {
		return getCategoryService().findAll();
	}

	@DeleteMapping("/categories/{id}")
	public void deleteById(@PathVariable int id) {
		getCategoryService().deleteById(id);
	}
}
