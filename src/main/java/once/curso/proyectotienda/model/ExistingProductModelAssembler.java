package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.restcontrollers.ExistingProductRestController;

@Component
public class ExistingProductModelAssembler implements SimpleRepresentationModelAssembler<ExistingProduct>{
@Override
	public void addLinks(EntityModel<ExistingProduct> existingProduct) {
		existingProduct.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExistingProductRestController. class)
				.findById(existingProduct.getContent().getId())).withSelfRel());
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<ExistingProduct>> existingProduct) {
		existingProduct.forEach(e ->{
			e.add(WebMvcLinkBuilder.linkTo(
					WebMvcLinkBuilder.methodOn(ExistingProductRestController. class)
					.findById(e.getContent().getId()))
					.withSelfRel());
			
		});
		
	}

}


