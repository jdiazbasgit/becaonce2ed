package once.curso.proyectotienda.restcontrollers;

import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.DocumentType;
import once.curso.proyectotienda.model.DocumentTypeModelAssembler;
import once.curso.proyectotienda.services.DocumentTypeService;

@Data
@RequestMapping("/once")
@RestController
public class DocumentTypeRestController {

	@Autowired
	private DocumentTypeService documentTypeService;

	@Autowired
	private PagedResourcesAssembler<DocumentType> pagedResourcesAssembler;

	@Autowired
	private DocumentTypeModelAssembler documentTypeModelAssembler;

	@GetMapping("/documentsTypes")
	@CrossOrigin(origins = "*")
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
	@CrossOrigin(origins = "*")
	public EntityModel<DocumentType> findById(@PathVariable int id) {
		DocumentType documentType = getDocumentTypeService().findById(id).get();
		documentType.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(DocumentTypeRestController.class).findById(documentType.getId()))
				.withSelfRel());

		return EntityModel.of(documentType);
	}

	@GetMapping("/documentsTypesPaginado")
	@CrossOrigin(origins = "*")
	public PagedModel<EntityModel<DocumentType>> findAllPaginado(@RequestParam int size, @RequestParam int page,
			@RequestParam String sort) {
		StringTokenizer stringTokenizer = new StringTokenizer(sort, ",");
		Sort orden = Sort.by("a");
		String campo = stringTokenizer.nextToken();
		String tipoOrden = stringTokenizer.nextToken();

		if (tipoOrden.equals("asc"))
			orden = Sort.by(campo).ascending();
		else
			orden = Sort.by(campo).descending();

		Pageable pageable = PageRequest.of(page, size, orden);
		Page<DocumentType> documentType = getDocumentTypeService().findAll(pageable);

		return getPagedResourcesAssembler().toModel(documentType, getDocumentTypeModelAssembler());
	}

	@PostMapping("/documentsTypes")
	@CrossOrigin(origins = "*")
	public boolean save(@RequestBody DocumentType documentType) {
		return existById(getDocumentTypeService().save(documentType).getId());
	}

	@DeleteMapping("/documentsTypes/{id}")
	@CrossOrigin(origins = "*")
	public boolean deleteById(@PathVariable int id) {
		getDocumentTypeService().deleteById(id);
		return getDocumentTypeService().existsById(id);
	}

	@PostMapping("/documentsTypes/{id}")
	@CrossOrigin(origins = "*")
	public boolean existById(@PathVariable int id) {
		return getDocumentTypeService().existsById(id);
	}
}
