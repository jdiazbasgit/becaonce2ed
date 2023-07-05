package once.curso.proyectobanco.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Description;
import once.curso.proyectobanco.entities.MappingFKDescription;
import once.curso.proyectobanco.services.MappingFKDescriptionService;

@RestController
@Data
@RequestMapping("/once")
@CrossOrigin(origins = "*")
public class MappingFKDescriptionRestController {
	

	@Autowired
	private MappingFKDescriptionService mappingFKDescriptionService;
	

	@GetMapping(value = "/mappingFKDescriptions")
	public Iterable<MappingFKDescription> findAll() {
		return getMappingFKDescriptionService().findAll();
	}
	
	@GetMapping("/saldo/{numeroCuenta}")
	public double getSaldo (@PathVariable int numeroCuenta) {
		return getMappingFKDescriptionService().getSaldo(numeroCuenta);
	}
	
}