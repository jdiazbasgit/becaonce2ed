package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.AwardsFine;
import once.curso.proyectobanco.restcontrollers.AwardFineRestControllers;

@Component
public class AwardFineModelAssembler implements SimpleRepresentationModelAssembler<AwardsFine>{

	@Override
	public void addLinks(EntityModel<AwardsFine> awardsFine) {
		awardsFine.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(AwardFineRestControllers.class)
						.findById(awardsFine.getContent().getId()))
				.withSelfRel());
		
	}

	
	public void addLinks(CollectionModel<EntityModel<AwardsFine>> awardFines) {
		awardFines.forEach(c -> {
			c.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(AwardFineRestControllers.class)
							.findById(c.getContent().getId()))
					.withSelfRel());
		});
		
	}

}
