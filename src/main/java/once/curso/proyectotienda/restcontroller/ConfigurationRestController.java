package once.curso.proyectotienda.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.Configuration;
import once.curso.proyectotienda.services.ConfigurationService;

@Data
@RequestMapping("/once")
@RestController
public class ConfigurationRestController {

	@Autowired
	private ConfigurationService configurationService;

	@GetMapping("/configurations")
	public Iterable<Configuration> dameConfiguraiones() {
		return getConfigurationService().findAll();

	}

	@GetMapping(value = "configurations/{id}")
	public Configuration getConfigurations(@PathVariable int id) {
		if (getConfigurationService().findById(id).isPresent())

			return getConfigurationService().findById(id).get();
		return null;
	}

	@PostMapping("/Configurations")
	public Configuration save(@RequestBody Configuration configuration) {
		return getConfigurationService().save(configuration);
	}

	@DeleteMapping("/configurations/{id}")
	public void deleteById(@PathVariable int id) {
		getConfigurationService().deleteById(id);
	}
}
