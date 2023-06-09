package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.Fee;
import once.curso.proyectobanco.restcontrollers.FeeRestController;

@Component
public class FeeModelAssembler implements SimpleRepresentationModelAssembler<Fee>{

	
	@Override
	public void addLinks(EntityModel<Fee> fee) {
		fee.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FeeRestController.class).findById(fee.getContent().getId())).withSelfRel());		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<Fee>> fees) {
		fees.forEach(f -> {
			f.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FeeRestController.class).findById(f.getContent().getId())).withSelfRel());
		});		
	}	
	
}
