package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.TimingType;
import once.curso.proyectobanco.restcontrollers.TimingTypeRestController;

@Component
public class TimingTypeModelAssembler implements SimpleRepresentationModelAssembler<TimingType> {

	@Override
	public void addLinks(EntityModel<TimingType> timingType) {
		timingType.add(WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(TimingTypeRestController.class).findById(timingType.getContent().getId()))
				.withSelfRel());
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<TimingType>> timingsTypes) {
		timingsTypes.forEach(t -> {
			t.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(TimingTypeRestController.class).findById(t.getContent().getId()))
					.withSelfRel());
		});
	}

}
