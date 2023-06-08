package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import once.curso.proyectobanco.entities.Configuration;
import once.curso.proyectobanco.restcontrollers.ConfigurationRestController;

@Component
public class ConfigurationModelAssember implements SimpleRepresentationModelAssembler<Configuration> {

	@Override
	public void addLinks(EntityModel<Configuration> configuration) {
		configuration.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConfigurationRestController.class)
				.findById(configuration.getContent().getId()))
				.withSelfRel());
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<Configuration>> configuration) {
		configuration.forEach(c ->{
			c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConfigurationRestController.class)
				.findById(c.getContent().getId()))
				.withSelfRel());
		});
		
	}

}
