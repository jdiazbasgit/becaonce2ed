package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectotienda.entities.Category;
import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.restcontrollers.CardTypeRestController;
import once.curso.proyectotienda.restcontrollers.CategoryRestController;
import once.curso.proyectotienda.restcontrollers.DocumentTypeRestController;
import once.curso.proyectotienda.restcontrollers.UserRestController;

@Component
public class ProfileModelAssembler implements SimpleRepresentationModelAssembler<Profile>{
@Override
	public void addLinks(EntityModel<Profile> profile) {
	profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryRestController.class)
				.findById(profile.getContent().getId())).withSelfRel());
	profile.add(WebMvcLinkBuilder
			 .linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).findById(profile.getContent().getUser().getId()))
			 .withRel("user"));
	profile.add(WebMvcLinkBuilder
			 .linkTo(WebMvcLinkBuilder.methodOn(CardTypeRestController.class).findById(profile.getContent().getCardType().getId()))
			 .withRel("cardTypes"));
	profile.add(WebMvcLinkBuilder
			 .linkTo(WebMvcLinkBuilder.methodOn(DocumentTypeRestController.class).findById(profile.getContent().getDocumentType().getId()))
			 .withRel("documentTypes"));
	}

@Override
public void addLinks(CollectionModel<EntityModel<Profile>> profile) {
	profile.forEach(p ->{
		p.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryRestController.class)
				.findById(p.getContent().getId())).withSelfRel());
		 p.add(WebMvcLinkBuilder
				 .linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).findById(p.getContent().getUser().getId()))
				 .withRel("user"));
		 p.add(WebMvcLinkBuilder
				 .linkTo(WebMvcLinkBuilder.methodOn(CardTypeRestController.class).findById(p.getContent().getCardType().getId()))
				 .withRel("cardTypes"));
		 p.add(WebMvcLinkBuilder
				 .linkTo(WebMvcLinkBuilder.methodOn(DocumentTypeRestController.class).findById(p.getContent().getDocumentType().getId()))
				 .withRel("documentTypes"));
		
	});
	
}

}
