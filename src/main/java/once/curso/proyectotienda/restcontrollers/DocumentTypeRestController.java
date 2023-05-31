package once.curso.proyectotienda.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.DocumentType;
import once.curso.proyectotienda.services.DocumentTypeService;

@Data
@RequestMapping("/v1/")
@RestController
public class DocumentTypeRestController {

	@Autowired
	private DocumentTypeService documentTypeService;

	@GetMapping("/documentsTypes")

	public CollectionModel<DocumentType> findAll() {
		Iterable<DocumentType> documentTypes = getDocumentTypeService().findAll();
		documentTypes.forEach(d -> {
			d.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(DocumentTypeRestController.class).findById(d.getId()))
					.withSelfRel());
		
		});
		return CollectionModel.of(documentTypes);
	}

	@GetMapping(value = "/documentsTypes/{id}")
	public EntityModel<DocumentType> findById(@PathVariable int id) {
		DocumentType documentType = getDocumentTypeService().findById(id).get();
		documentType.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(DocumentTypeRestController.class).findById(documentType.getId()))
				.withSelfRel());

		return EntityModel.of(documentType);
	}

	@PostMapping("/document_types")
	public DocumentType save(@RequestBody DocumentType documentType) {
		return getDocumentTypeService().save(documentType);
	}

	@DeleteMapping("/document_types/{id}")
	public void deleteById(@PathVariable int id) {
		getDocumentTypeService().deleteById(id);
	}
}
