package once.curso.proyectobanco.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
	
	@GetMapping(value =" /configurations/{id}")
	
	public EntityModel< Configuration> findById(@PathVariable Integer id) {
		Configuration configuration= getConfigurationService().findById(id).get();
		configuration.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConfigurationRestController.class)
				.findById(configuration.getId())).withSelfRel());
		
		 return  EntityModel.of(configuration);
		 
	}
	@GetMapping(value = "/configurations")
	public CollectionModel<Configuration> findAll() {
		 Iterable<Configuration> configuration= getConfigurationService().findAll();
		 configuration.forEach(c->{
			 c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConfigurationRestController.class)
						.findById(c.getId())).withSelfRel());
					 });
		 return CollectionModel.of(configuration);
	}
	@PostMapping(value = "/configurations")
	public Configuration save(@RequestBody Configuration configuration) {
		return getConfigurationService().save(configuration);
	}
	@DeleteMapping(value="/configurations")
	public void deleteById(@PathVariable Integer id) {
		getConfigurationService().deleteById(id);
	}
	
	

}
