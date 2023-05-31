package once.curso.proyectotienda.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	@CrossOrigin(origins = "*")
	public CollectionModel<Configuration> findAll(){
		Iterable<Configuration> configurations = getConfigurationService().findAll();
		configurations.forEach(c -> {
			c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConfigurationRestController.class).findById(c.getId())).withSelfRel());
		});
		
		
		return CollectionModel.of(configurations);
	}
	/*
	 * http://localhost:8080/once/configurations
	 */

	@GetMapping(value = "configurations/{id}")
	@CrossOrigin(origins = "*")
	public EntityModel<Configuration> findById(@PathVariable int id) {
		Configuration configurations = getConfigurationService().findById(id).get();
		configurations.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ConfigurationRestController.class).findById(configurations.getId()))
				.withSelfRel());

		return EntityModel.of(configurations);
	}
	/*
	 * http://localhost:8080/once/configurations/225
	 */

	@PostMapping("/configurations")
	@CrossOrigin(origins = "*")
	public Configuration save(@RequestBody Configuration configuration) {
		return getConfigurationService().save(configuration);
	}
	/*
	 * http://localhost:8080/once/configurations
	 */

	@DeleteMapping("/configurations/{id}")
	@CrossOrigin(origins = "*")
	public void deleteById(@PathVariable int id) {
		getConfigurationService().deleteById(id);
	}
	/*
	 * http://localhost:8080/once/configurations/300
	 */

}
