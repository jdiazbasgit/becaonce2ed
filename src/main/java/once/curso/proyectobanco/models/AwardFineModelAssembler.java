package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.AwardFine;
import once.curso.proyectobanco.restcontrollers.AwardFineTypeRestController;
import once.curso.proyectobanco.restcontrollers.AwardFineConfigurationRestController;
import once.curso.proyectobanco.restcontrollers.AwardFineRestController;

@Component
public class AwardFineModelAssembler implements SimpleRepresentationModelAssembler<AwardFine>{

	@Override
	public void addLinks(EntityModel<AwardFine> awardFine) {
		awardFine.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestController.class)
				  .findById(awardFine.getContent().getAwardFineType().getId())).withRel("awardFineType"));
		awardFine.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineConfigurationRestController.class)
				  .findById(awardFine.getContent().getAwardFineConfiguration().getId())).withRel("awardFineConfiguration"));
		awardFine.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineRestController.class)
					.findById(awardFine.getContent().getId())).withSelfRel());
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<AwardFine>> awardsFines) {
		awardsFines.forEach(awardFine -> {
		awardFine.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestController.class)
				  .findById(awardFine.getContent().getAwardFineType().getId())).withRel("awardFineType"));
		awardFine.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineConfigurationRestController.class)
				  .findById(awardFine.getContent().getAwardFineConfiguration().getId())).withRel("awardFineConfiguration"));
		awardFine.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineRestController.class)
					.findById(awardFine.getContent().getId())).withSelfRel());
		});		
	}	
	
}
