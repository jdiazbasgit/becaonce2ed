package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.AwardsFinesConfiguration;
import once.curso.proyectobanco.restcontrollers.AwardsFinesConfigurationRestControllers;

@Component
public class AwardsFinesConfigurationModelAssembler implements SimpleRepresentationModelAssembler<AwardsFinesConfiguration>{

	@Override
	public void addLinks(EntityModel<AwardsFinesConfiguration> awardsFinesConfiguration) {
		awardsFinesConfiguration.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(AwardsFinesConfigurationRestControllers.class)
						.findById(awardsFinesConfiguration.getContent().getId()))
				.withSelfRel());
		
	}

	
	public void addLinks(CollectionModel<EntityModel<AwardsFinesConfiguration>> awadsFinesConfigurations) {
		awadsFinesConfigurations.forEach(c -> {
			c.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(AwardsFinesConfigurationRestControllers.class)
									.findById(c.getContent().getId()))
							.withSelfRel());
			
		});
		
	}

}
