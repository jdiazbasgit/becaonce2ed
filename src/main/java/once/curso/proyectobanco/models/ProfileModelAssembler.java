package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.Profile;
import once.curso.proyectobanco.restcontrollers.ProfileRestController;

@Component
public class ProfileModelAssembler implements SimpleRepresentationModelAssembler<Profile>{

	@Override
	public void addLinks(EntityModel<Profile> profile) {
		profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class).findById(profile.getContent().getId())).withSelfRel());		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<Profile>> profiles) {
		profiles.forEach(p -> {
			p.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class).findById(p.getContent().getId())).withSelfRel());
		});		
	}	
	
}