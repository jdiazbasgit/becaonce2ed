package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectotienda.entities.User;
import once.curso.proyectotienda.restcontrollers.UserRestController;

@Component
public class UserModelAssembler implements SimpleRepresentationModelAssembler<User> {

	public void addLinks(EntityModel<User> user) {
		user.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class)
				.findById(user.getContent().getId())).withSelfRel());
		user.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class)
				.findById(user.getContent().getRol().getId())).withRel("rol"));
	}

	public void addLinks(CollectionModel<EntityModel<User>> user) {
		user.forEach(u->{
			u.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class)
					.findById(u.getContent().getId())).withSelfRel());
			u.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class)
					.findById(u.getContent().getRol().getId())).withRel("rol"));
		});
	}
}
