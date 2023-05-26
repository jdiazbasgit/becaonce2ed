package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import once.curso.proyectobanco.entities.Transaction;
import once.curso.proyectobanco.restcontrollers.CurrentAccountRestController;
import once.curso.proyectobanco.restcontrollers.DescriptionRestController;
import once.curso.proyectobanco.restcontrollers.TransactionRestController;

public class TransactionModelAssembler implements SimpleRepresentationModelAssembler<Transaction> {

	@Override
	public void addLinks(EntityModel<Transaction> transaction) {
		transaction.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TransactionRestController.class).
				findById(transaction.getContent().getId())).withSelfRel());
		transaction.add(WebMvcLinkBuilder.
				linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class).findById(transaction.getContent().getDescription().getId()))
				.withRel("description"));
		transaction.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class).findById(transaction.getContent().getCurrentAccount().getId()))
				.withRel("currentAccount"));
		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<Transaction>> transaction) {
		transaction.forEach(t->{
			t.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(TransactionRestController.class).findById(t.getContent().getId()))
					.withSelfRel());
			t.add(WebMvcLinkBuilder.
					linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class).findById(t.getContent().getDescription().getId()))
					.withRel("description"));
			t.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class).findById(t.getContent().getCurrentAccount().getId()))
					.withRel("currentAccount"));
		});
		
	}

}
