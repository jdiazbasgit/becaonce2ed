package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.IdentificationType;
import once.curso.proyectobanco.restcontrollers.IdentificationTypeRestController;

@Component
public class IdentificationTypeModelAssembler implements SimpleRepresentationModelAssembler<IdentificationType>{

	
	@Override
	public void addLinks(EntityModel<IdentificationType> identificationType) {
		identificationType.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(IdentificationTypeRestController.class).findById(identificationType.getContent().getId())).withSelfRel());		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<IdentificationType>> identificationTypes) {
		identificationTypes.forEach(i -> {
			i.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(IdentificationTypeRestController.class).findById(i.getContent().getId())).withSelfRel());
		});		
	}	
	
}