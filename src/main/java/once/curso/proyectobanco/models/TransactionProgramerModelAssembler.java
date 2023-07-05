package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import lombok.Data;
import once.curso.proyectobanco.entities.TransactionProgramer;
import once.curso.proyectobanco.restcontrollers.CurrentAccountRestController;
import once.curso.proyectobanco.restcontrollers.DescriptionRestController;
import once.curso.proyectobanco.restcontrollers.TimingTypeRestController;
import once.curso.proyectobanco.restcontrollers.TransactionProgramerRestController;
@Data
@Component
public class TransactionProgramerModelAssembler implements SimpleRepresentationModelAssembler<TransactionProgramer> {

	@Override
	public void addLinks(EntityModel<TransactionProgramer> transactionProgramer) {
		transactionProgramer.add(WebMvcLinkBuilder.
				linkTo(WebMvcLinkBuilder.methodOn(TransactionProgramerRestController.class).findById(transactionProgramer.getContent().getId())).withSelfRel());
		
		transactionProgramer.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class).findById(transactionProgramer.getContent().getCurrentAccount().getId()))
				.withRel("currentAccount"));
		
		transactionProgramer.add(WebMvcLinkBuilder.
				linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class).findById(transactionProgramer.getContent().getDescription().getId()))
				.withRel("description"));
		
		transactionProgramer.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TimingTypeRestController.class).
				findById(transactionProgramer.getContent().getTimingType().getId())).withRel("timingType"));
		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<TransactionProgramer>> transactionProgramer) {
		transactionProgramer.forEach(tp->{
			tp.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TransactionProgramerRestController.class).
					findById(tp.getContent().getId())).withSelfRel());
			tp.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class).
					findById(tp.getContent().getId())).withRel("currentAccount"));
			tp.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class).
					findById(tp.getContent().getId())).withRel("description"));
			tp.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TimingTypeRestController.class).
					findById(tp.getContent().getId())).withRel("timingType"));
		});
		
	}
	

}
