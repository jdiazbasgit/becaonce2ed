package once.curso.proyectobanco.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Configuration;
import once.curso.proyectobanco.entities.Description;
import once.curso.proyectobanco.services.ConfigurationService;
import once.curso.proyectobanco.services.DescriptionService;

@RestController
@Data
@RequestMapping("/once")
public class DescriptionRestController {
	@Autowired
	private DescriptionService descriptionService;
	
	@GetMapping(value =" /configuration/{id}")
	public Description findById(@PathVariable Integer id) {
		return getDescriptionService().findById(id).get();
	}
	@GetMapping(value = "/description")
	public Iterable<Description> findAll(@PathVariable Integer id) {
		return getDescriptionService().findAll();
	}
	@PostMapping(value = "/description")
	public Description save(@RequestBody Description description) {
		return getDescriptionService().save(description);
	}
	@DeleteMapping(value="/descriptiuon")
	public void deleteById(@PathVariable Integer id) {
		getDescriptionService().deleteById(id);
	}
	
}
