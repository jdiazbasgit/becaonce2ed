package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.Rol;
import once.curso.proyectobanco.restcontrollers.RolRestController;

@Component
public class RolModelAssembler implements SimpleRepresentationModelAssembler<Rol> {

	@Override
	public void addLinks(EntityModel<Rol> rol) {
		rol.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class).findById(rol.getContent().getId())).withSelfRel());
		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<Rol>> roles) {
		roles.forEach(r->{
			r.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class).findById(r.getContent().getId())).withSelfRel());
		});
		
	}
	

}
