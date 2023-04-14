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
import once.curso.proyectotienda.entities.Category;
import once.curso.proyectotienda.services.CategoryService;

@RestController
@RequestMapping("/once")
@Data
public class SoldProductRestController {

	@Autowired
	private SoldProductService soldProductService;

	@PostMapping("/soldProducts")
	public SoldProduct save(@RequestBody SoldProduct oldProduct) {
		return getSoldProductService().save(soldProduct);
	}

	@GetMapping("/soldProducts")
	public Iterable<SoldProduct> findAll() {
		return getSoldProductService().findAll();
	}

	@DeleteMapping("/soldProducts/{id}")
	public void deleteById(@PathVariable int id) {
		getSoldProductService().deleteById(id);
	}
}
