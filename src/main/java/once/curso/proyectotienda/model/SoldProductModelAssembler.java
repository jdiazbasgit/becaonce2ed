package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectotienda.entities.SoldProduct;

import once.curso.proyectotienda.restcontrollers.SoldProductRestController;

@Component
public class SoldProductModelAssembler implements SimpleRepresentationModelAssembler<SoldProduct>{
@Override
	public void addLinks(EntityModel<SoldProduct> soldProduct) {
		soldProduct.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SoldProductRestController. class)
				.findById(soldProduct.getContent().getId())).withSelfRel());
	}

@Override
public void addLinks(CollectionModel<EntityModel<SoldProduct>> soldProduct) {
	soldProduct.forEach(s ->{
		s.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SoldProductRestController. class)
				.findById(s.getContent().getId())).withSelfRel());
		
	});
	
}

}
