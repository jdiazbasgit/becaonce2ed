package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectotienda.entities.DocumentType;
import once.curso.proyectotienda.restcontrollers.DocumentTypeRestController;

@Component
public class DocumentTypeModelAssembler implements SimpleRepresentationModelAssembler<DocumentType> {

	@Override
	public void addLinks(EntityModel<DocumentType> documentType) {
		documentType.add(WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(DocumentTypeRestController.class)
				.findById(documentType.getContent().getId())).withSelfRel());
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<DocumentType>> documentType) {
		documentType.forEach(d -> {
			d.add(WebMvcLinkBuilder.linkTo(
					WebMvcLinkBuilder.methodOn(DocumentTypeRestController.class).findById(d.getContent().getId()))
					.withSelfRel());
		});
	}

}
