package once.curso.proyectotienda.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.SubCategory;
import once.curso.proyectotienda.services.SubcategoryService;

@Data
@RequestMapping("/tienda")
@RestController
public class SubCategoryRestController {

	@Autowired
	private SubcategoryService subcategoryService;
	
	@PostMapping("/subcategory")
	public SubCategory save(@RequestBody SubCategory subCategory) {
		return getSubcategoryService().save(subCategory);
	}
	
	@GetMapping("/subcategory")
	public Iterable<SubCategory> findAll(){
		return getSubcategoryService().findAll();
	}
	
	@DeleteMapping("/subcategory/{id}")
	public void deleteById(@PathVariable int id) {
		getSubcategoryService().deleteById(id);
	}
}
