package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.AwardFineType;
import once.curso.proyectobanco.restcontrollers.AwardFineTypeRestController;


@Component
public class AwardFineTypeModelAssembler implements SimpleRepresentationModelAssembler<AwardFineType>{

	@Override
	public void addLinks(EntityModel<AwardFineType> awardFineType) {
		awardFineType.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestController.class)
					.findById(awardFineType.getContent().getId())).withSelfRel());
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<AwardFineType>> awardsFinesTypes) {
		awardsFinesTypes.forEach(awardFineType -> {
		awardFineType.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestController.class)
					.findById(awardFineType.getContent().getId())).withSelfRel());
		});		
	}	
	
}
