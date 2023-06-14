package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.AwardsFine;
import once.curso.proyectobanco.restcontrollers.AwardFineRestControllers;
import once.curso.proyectobanco.restcontrollers.AwardFineTypeRestControllers;
import once.curso.proyectobanco.restcontrollers.AwardsFinesConfigurationRestControllers;

@Component
public class AwardsFineModelAssembler implements SimpleRepresentationModelAssembler<AwardsFine>{

	@Override
	public void addLinks(EntityModel<AwardsFine> awardsFine) {
		awardsFine.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestControllers.class)
				.findById(awardsFine.getContent().getAwardFineType().getId())).withRel("awardFineType"));
		
		awardsFine.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardsFinesConfigurationRestControllers.class)
				.findById(awardsFine.getContent().getAwardFineConfiguration().getId())).withRel("awardFineConfiguration"));
				
		awardsFine.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(AwardFineRestControllers.class)
						.findById(awardsFine.getContent().getId()))
				.withSelfRel());
		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<AwardsFine>> awardsFines) {
		awardsFines.forEach(c -> {
			c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestControllers.class)
					.findById(c.getContent().getAwardFineType().getId())).withRel("awardFineType"));
			
			c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardsFinesConfigurationRestControllers.class)
					.findById(c.getContent().getAwardFineConfiguration().getId())).withRel("awardFineConfiguration"));
			
			c.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(AwardFineRestControllers.class)
							.findById(c.getContent().getId())).withSelfRel());
		});
		
	}

}
