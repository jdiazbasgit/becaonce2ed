package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.TransactionsAwardsFine;
import once.curso.proyectobanco.restcontrollers.TransactionsAwardsFineResController;


@Component
public class TransactionsAwardsFineAssember implements SimpleRepresentationModelAssembler<TransactionsAwardsFine>{

	@Override
	public void addLinks(EntityModel<TransactionsAwardsFine> transactionsAwardsFine) {
		transactionsAwardsFine.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(TransactionsAwardsFineResController.class)
						.findById(transactionsAwardsFine.getContent().getId()))
				.withSelfRel());
		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<TransactionsAwardsFine>> transactionsAwardsFine) {
		transactionsAwardsFine.forEach(t ->{
			t.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(TransactionsAwardsFineResController.class)
							.findById(t.getContent().getId()))
					.withSelfRel());
		});
		
	}

}
