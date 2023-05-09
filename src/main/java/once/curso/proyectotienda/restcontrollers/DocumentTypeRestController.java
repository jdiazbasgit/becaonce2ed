package once.curso.proyectotienda.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/once")
@RestController
public class DocumentTypeRestController {

	@Autowired
	private DocumentTypeService documentTypeService;

	@GetMapping("/documents_types")
	public Iterable<DocumentType> dameTipoDeDocumentos() {
		return getDocumentTypeService().findAll();
	}

	@GetMapping(value = "/documents_types/{id}")
	public DocumentType getDocumentTypes(@PathVariable int id) {
		if (getDocumentTypeService().findById(id).isPresent())

			return getDocumentTypeService().findById(id).get();
		return null;
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
