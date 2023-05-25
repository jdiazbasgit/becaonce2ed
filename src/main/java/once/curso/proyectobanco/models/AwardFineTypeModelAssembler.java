package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.AwardsFinesType;
import once.curso.proyectobanco.restcontrollers.AwardFineTypeRestControllers;

@Component
public class AwardFineTypeModelAssembler implements SimpleRepresentationModelAssembler<AwardsFinesType>{

	@Override
	public void addLinks(EntityModel<AwardsFinesType> awardsFinesType) {
		awardsFinesType.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestControllers.class)
						.findById(awardsFinesType.getContent().getId()))
				.withSelfRel());
		
	}

	
	public void addLinks(CollectionModel<EntityModel<AwardsFinesType>> awa) {
		
	}

}
