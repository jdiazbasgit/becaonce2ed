package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.AwardFineConfiguration;
import once.curso.proyectobanco.restcontrollers.DescriptionRestController;
import once.curso.proyectobanco.restcontrollers.AwardFineConfigurationRestController;

@Component
public class AwardFineConfigurationModelAssembler implements SimpleRepresentationModelAssembler<AwardFineConfiguration>{

	@Override
	public void addLinks(EntityModel<AwardFineConfiguration> awardFineConfiguration) {
		awardFineConfiguration.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class)
				  .findById(awardFineConfiguration.getContent().getDescription().getId())).withRel("description"));
		awardFineConfiguration.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineConfigurationRestController.class)
					.findById(awardFineConfiguration.getContent().getId())).withSelfRel());
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<AwardFineConfiguration>> awardsFinesConfigurations) {
		awardsFinesConfigurations.forEach(awardFineConfiguration -> {
		awardFineConfiguration.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class)
				  .findById(awardFineConfiguration.getContent().getDescription().getId())).withRel("description"));
		awardFineConfiguration.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineConfigurationRestController.class)
					.findById(awardFineConfiguration.getContent().getId())).withSelfRel());
		});		
	}	
	
}
