package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.IdentificationType;
import once.curso.proyectobanco.services.IdentificationTypeService;

@RestController
@Data
@RequestMapping("/once")
public class IdentificationTypeRestController {

	@Autowired
	private IdentificationTypeService identificationTypeService;

@GetMapping(value = "/identificationsTypes/{id}")
	public IdentificationType findById(@PathVariable Integer id) {
		return getIdentificationTypeService().findById(id).get();
	}
	
	@GetMapping(value = "/identificationsTypes")
	public Iterable<IdentificationType> findAll() {
		return getIdentificationTypeService().findAll();
	}
	
	@PostMapping("/identificationsTypes")
	public IdentificationType save(@RequestBody IdentificationType identificationType) {
		return getIdentificationTypeService().save(identificationType);
	}
	
	@PutMapping("/identificationsTypes")
	public List <IdentificationType> saveAll(@RequestBody List<IdentificationType> identificationsTypes) {
		return (List<IdentificationType>) getIdentificationTypeService().saveAll(identificationsTypes);
	}

	@DeleteMapping("/identificationsTypes/{id}")
	public void deleteById(@PathVariable int id) {
		getIdentificationTypeService().deleteById(id);
	}	
}