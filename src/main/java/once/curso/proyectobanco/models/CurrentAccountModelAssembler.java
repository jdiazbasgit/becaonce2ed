package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.CurrentAccount;
import once.curso.proyectobanco.restcontrollers.CurrentAccountRestController;

@Component
public class CurrentAccountModelAssembler implements SimpleRepresentationModelAssembler<CurrentAccount> {

	@Override
	public void addLinks(EntityModel<CurrentAccount> currentAccount) {
		
		currentAccount.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class)
						.findById(currentAccount.getContent().getId()))
				.withSelfRel());
		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<CurrentAccount>> currentAccounts) {
		

		currentAccounts.forEach(ca ->{
			ca.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class)
					.findById(ca.getContent().getId()))
					.withSelfRel());
		});
		
	}

}
