package once.curso.proyectobanco.models;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectobanco.entities.CurrentAccount;
import once.curso.proyectobanco.restcontrollers.CurrentAccountRestController;
import once.curso.proyectobanco.restcontrollers.FeeRestController;
import once.curso.proyectobanco.restcontrollers.IdentificationTypeRestController;
import once.curso.proyectobanco.restcontrollers.TypeAccountRestController;
import once.curso.proyectobanco.restcontrollers.UserRestController;

@Component
public class CurrentAccountModelAssembler implements SimpleRepresentationModelAssembler<CurrentAccount> {

	@Override
	public void addLinks(EntityModel<CurrentAccount> currentAccount) {
		currentAccount.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FeeRestController.class)
				  .findById(currentAccount.getContent().getFee().getId())).withRel("fee"));
		currentAccount.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TypeAccountRestController.class)
				  .findById(currentAccount.getContent().getTypeAccount().getId())).withRel("typeAccount"));
		currentAccount.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class)
				  .findById(currentAccount.getContent().getUser().getId())).withRel("user"));
		currentAccount.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class)
						.findById(currentAccount.getContent().getId()))
				.withSelfRel());
		
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<CurrentAccount>> currentAccounts) {
		currentAccounts.forEach(ca ->{
			ca.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FeeRestController.class)
					  .findById(ca.getContent().getFee().getId())).withRel("fee"));
			ca.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TypeAccountRestController.class)
					  .findById(ca.getContent().getTypeAccount().getId())).withRel("typeAccount"));
			ca.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class)
					  .findById(ca.getContent().getUser().getId())).withRel("user"));
			ca.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(CurrentAccountRestController.class)
					.findById(ca.getContent().getId()))
					.withSelfRel());
		});
		
	}

}
