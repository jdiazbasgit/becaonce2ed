package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectotienda.entities.SubCategory;
import once.curso.proyectotienda.restcontrollers.SubCategoryRestController;

@Component
public class SubCategoryModelAssembler implements SimpleRepresentationModelAssembler<SubCategory>{
@Override
	public void addLinks(EntityModel<SubCategory> subcategory) {
		subcategory.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SubCategoryRestController. class)
				.findById(subcategory.getContent().getId())).withSelfRel());
	}

@Override
public void addLinks(CollectionModel<EntityModel<SubCategory>> subcategory) {
	subcategory.forEach(s ->{
		s.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SubCategoryRestController. class)
				.findById(s.getContent().getId())).withSelfRel());
		
	});
	
}



}
