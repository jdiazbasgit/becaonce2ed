package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectotienda.entities.SoldProduct;
import once.curso.proyectotienda.restcontrollers.ExistingProductRestController;
import once.curso.proyectotienda.restcontrollers.ProfileRestController;
import once.curso.proyectotienda.restcontrollers.SoldProductRestController;

@Component
public class SoldProductModelAssembler implements SimpleRepresentationModelAssembler<SoldProduct>{

	@Override
	public void addLinks(EntityModel<SoldProduct> soldProduct) {
		soldProduct.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class).findById(soldProduct.getContent().getProfile().getId())).withRel("profile"));
		soldProduct.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExistingProductRestController.class).findById(soldProduct.getContent().getExistingProduct().getId())).withRel("existingProduct"));
		soldProduct.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SoldProductRestController.class).findById(soldProduct.getContent().getId())).withSelfRel());
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<SoldProduct>> soldProduct) {
		soldProduct.forEach(s ->{
			s.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class).findById(s.getContent().getProfile().getId())).withRel("profile"));
			s.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExistingProductRestController.class).findById(s.getContent().getExistingProduct().getId())).withRel("existingProduct"));
			s.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SoldProductRestController.class).findById(s.getContent().getId())).withSelfRel());
		});
	}

}
