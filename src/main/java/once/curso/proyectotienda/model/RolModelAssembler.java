package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectotienda.entities.Rol;
import once.curso.proyectotienda.restcontrollers.RolRestController;

@Component
public class RolModelAssembler implements SimpleRepresentationModelAssembler<Rol> {

	public void addLinks(EntityModel<Rol> rol) {
		rol.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class)
				.findById(rol.getContent().getId())).withSelfRel());
	}

	public void addLinks(CollectionModel<EntityModel<Rol>> rol) {
		rol.forEach(r->{
			r.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class)
					.findById(r.getContent().getId())).withSelfRel());
		});
	}

}
