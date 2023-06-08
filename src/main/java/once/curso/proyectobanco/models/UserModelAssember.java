package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.User;
import once.curso.proyectobanco.restcontrollers.UserRestController;

@Component
public class UserModelAssember implements SimpleRepresentationModelAssembler<User>{

	@Override
	public void addLinks(EntityModel<User> user) {
		user.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class)
						.findById(user.getContent().getId()))
				.withSelfRel());
		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<User>> user) {
		user.forEach(u ->{
			u.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class)
							.findById(u.getContent().getId()))
				.withSelfRel());
		
		
		});
	}
}



