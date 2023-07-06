package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.restcontrollers.CardTypeRestController;
import once.curso.proyectotienda.restcontrollers.DocumentTypeRestController;
import once.curso.proyectotienda.restcontrollers.ProfileRestController;
import once.curso.proyectotienda.restcontrollers.UserRestController;

/* PARA LIMIEZA LOS ERRORES CON SUBRAYA ROJOS :: PULSA CONTROL + SHIFT + O */
/* PULSA UserRestController.class y pulsa F3 PARA ACCEDER A OTRA CLASE */
/* EJEMPLO EL JSON ASI */
/*
	"_links": {
		"user": {
			"href": "http://localhost:8080/once/users/XX"
		},
		"cardTypes": {
			"href": "http://localhost:8080/once/cardTypes/XX"
		},
		"documentTypes": {
			"href": "http://localhost:8080/once/documentsTypes/XX"
		},
			"self": {
			"href": "http://localhost:8080/once/profiles/XX"
		}
	}
 */

@Component
public class ProfileModelAssembler implements SimpleRepresentationModelAssembler<Profile>{
	/* (1) ONE */
	@Override
	public void addLinks(EntityModel<Profile> profile) {
	profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class)
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

	/* (*) MANY */
	/* methodOn es un método estático proporcionado por la clase WebMvcLinkBuilder en Spring Framework. Se utiliza para construir enlaces a métodos de controlador 
	 en el contexto de la generación de HATEOAS (Hypermedia as the Engine of Application State).
	 El propósito principal de methodOn es crear una representación segura de un método de controlador enlazado. Toma como argumentos la clase del controlador 
	 y el método que deseas enlazar. A través de la reflexión, methodOn crea un objeto proxy que representa el método de controlador, lo cual permite obtener 
	 información sobre el método, como su nombre y parámetros, sin ejecutarlo realmente.
	 
	 El uso común de methodOn es en combinación con linkTo para crear enlaces a métodos de controlador en los métodos addLinks de los ensambladores 
	 de modelos en HATEOAS. */
	
	@Override
	public void addLinks(CollectionModel<EntityModel<Profile>> profile) {
	profile.forEach(p ->{
		p.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class)
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
