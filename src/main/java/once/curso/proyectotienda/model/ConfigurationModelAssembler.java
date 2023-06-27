package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectotienda.entities.Configuration;
import once.curso.proyectotienda.restcontrollers.ConfigurationRestController;

@Component
public class ConfigurationModelAssembler implements SimpleRepresentationModelAssembler<Configuration> {

	@Override
	public void addLinks(EntityModel<Configuration> configuration) {
		configuration.add(WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(ConfigurationRestController.class).findById(configuration.getContent().getId()))
				.withSelfRel());
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<Configuration>> configuration) {
		configuration.forEach(c -> {
			c.add(WebMvcLinkBuilder.linkTo(
					WebMvcLinkBuilder.methodOn(ConfigurationRestController.class).findById(c.getContent().getId()))
					.withSelfRel());
		});
	}

}
