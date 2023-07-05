package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.TransactionAwardFine;
import once.curso.proyectobanco.restcontrollers.AwardFineTypeRestController;
import once.curso.proyectobanco.restcontrollers.IdentificationTypeRestController;
import once.curso.proyectobanco.restcontrollers.TransactionRestController;
import once.curso.proyectobanco.restcontrollers.TransactionsAwardsFineResController;
import once.curso.proyectobanco.restcontrollers.UserRestController;


@Component
public class TransactionAwardsFineAssember implements SimpleRepresentationModelAssembler<TransactionAwardFine>{

	@Override
	public void addLinks(EntityModel<TransactionAwardFine> transactionsAwardsFine) {
		transactionsAwardsFine.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TransactionRestController.class)
				  .findById(transactionsAwardsFine.getContent().getTransaction().getId())).withRel("transaction"));
		transactionsAwardsFine.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestController.class)
				  .findById(transactionsAwardsFine.getContent().getAwardFineType().getId())).withRel("awardFineType"));
		transactionsAwardsFine.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(TransactionsAwardsFineResController.class)
						.findById(transactionsAwardsFine.getContent().getId()))
				.withSelfRel());
		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<TransactionAwardFine>> transactionsAwardsFine) {
		transactionsAwardsFine.forEach(t ->{
			t.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TransactionRestController.class)
					  .findById(t.getContent().getTransaction().getId())).withRel("transaction"));
			  t.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestController.class)
					  .findById(t.getContent().getAwardFineType().getId())).withRel("awardFineType"));
			t.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(TransactionsAwardsFineResController.class)
							.findById(t.getContent().getId()))
					.withSelfRel());
		});
		
	}

}
