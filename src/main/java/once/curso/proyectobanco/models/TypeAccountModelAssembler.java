package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.TypeAccount;
import once.curso.proyectobanco.restcontrollers.TypeAccountRestController;

@Component
public class TypeAccountModelAssembler implements SimpleRepresentationModelAssembler<TypeAccount>{

	@Override
	public void addLinks(EntityModel<TypeAccount> typeAccount) {
		typeAccount.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TypeAccountRestController.class).
				 findById(typeAccount.getContent().getId())).withSelfRel());
		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<TypeAccount>> typeAccount) {
		typeAccount.forEach(t->{
			 t.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TypeAccountRestController.class).
					 findAll()).withSelfRel());
		});
		
	}

}
