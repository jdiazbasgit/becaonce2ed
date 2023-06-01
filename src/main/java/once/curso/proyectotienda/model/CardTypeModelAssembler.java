package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectotienda.entities.CardType;
import once.curso.proyectotienda.restcontrollers.CardTypeRestController;
@Component
public class CardTypeModelAssembler implements SimpleRepresentationModelAssembler<CardType> {

	@Override
	public void addLinks(EntityModel<CardType> cardType) {

		cardType.add(WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(CardTypeRestController.class).findById(cardType.getContent().getId()))
				.withSelfRel());

	}

	@Override
	public void addLinks(CollectionModel<EntityModel<CardType>> cardType) {

		cardType.forEach(c -> {
			c.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(CardTypeRestController.class).findById(c.getContent().getId()))
					.withSelfRel());

		});
	}

}
