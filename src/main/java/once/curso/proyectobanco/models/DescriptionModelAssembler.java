package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.Description;
import once.curso.proyectobanco.restcontrollers.DescriptionRestController;

@Component
public class DescriptionModelAssembler implements SimpleRepresentationModelAssembler<Description>{

	@Override
	public void addLinks(EntityModel<Description> description) {
		
		description.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class)
						.findById(description.getContent().getId()))
				.withSelfRel());
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<Description>> descriptions) {
		descriptions.forEach(d ->{
			d.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class)
							.findById(d.getContent().getId()))
					.withSelfRel());
		});
		
	}

}
