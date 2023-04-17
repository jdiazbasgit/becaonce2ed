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
import once.curso.proyectobanco.services.ConfigurationService;

@RestController
@Data
@RequestMapping("/once")
public class ConfigurationRestController {
	@Autowired
	private ConfigurationService configurationService;
	
	@GetMapping(value =" /configuration/{id}")
	public Configuration findById(@PathVariable Integer id) {
		return getConfigurationService().findById(id).get();
	}
	@GetMapping(value = "/configuration")
	public Iterable<Configuration> findAll(@PathVariable Integer id) {
		return getConfigurationService().findAll();
	}
	@PostMapping(value = "/configuration")
	public Configuration save(@RequestBody Configuration configuration) {
		return getConfigurationService().save(configuration);
	}
	@DeleteMapping(value="/configuration")
	public void deleteById(@PathVariable Integer id) {
		getConfigurationService().deleteById(id);
	}
	
	

}
