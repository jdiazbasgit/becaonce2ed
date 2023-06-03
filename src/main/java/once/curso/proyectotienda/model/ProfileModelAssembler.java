package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectotienda.entities.Category;
import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.restcontrollers.CategoryRestController;

@Component
public class ProfileModelAssembler implements SimpleRepresentationModelAssembler<Profile>{
@Override
	public void addLinks(EntityModel<Profile> profile) {
	profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryRestController. class)
				.findById(profile.getContent().getId())).withSelfRel());
	}

@Override
public void addLinks(CollectionModel<EntityModel<Profile>> profile) {
	profile.forEach(c ->{
		c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryRestController. class)
				.findById(c.getContent().getId())).withSelfRel());
		
	});
	
}

}
