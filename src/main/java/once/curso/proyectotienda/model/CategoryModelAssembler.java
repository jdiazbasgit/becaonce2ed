package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectotienda.entities.Category;
import once.curso.proyectotienda.restcontrollers.CategoryRestController;

@Component
public class CategoryModelAssembler implements SimpleRepresentationModelAssembler<Category>{
@Override
	public void addLinks(EntityModel<Category> category) {
		category.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryRestController. class)
				.findById(category.getContent().getId())).withSelfRel());
	}

@Override
public void addLinks(CollectionModel<EntityModel<Category>> category) {
	category.forEach(c ->{
		c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryRestController. class)
				.findById(c.getContent().getId())).withSelfRel());
		
	});
	
}

}
