package once.curso.ejemplojpa.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.restcontrollers.ChildRestController;

@Component
public class ChildModelAssembler implements SimpleRepresentationModelAssembler<Child> {

	@Override
	public void addLinks(EntityModel<Child> child) {
		child.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ChildRestController.class)
						.getChildrenById(child.getContent().getId()))
				.withSelfRel());

	}


	public void addLinks(CollectionModel<EntityModel<Child>> children) {
		children.forEach(c -> {
			c.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(ChildRestController.class)
							.getChildrenById(c.getContent().getId()))
					.withSelfRel());
		});

	}

}
