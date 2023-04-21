package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.entities.Configuration;
import once.curso.proyectotienda.entities.DocumentType;
import once.curso.proyectotienda.services.DocumentTypeService;

@Data
@SpringBootTest
public class DocumentTypeTest {

	@Autowired
	private DocumentTypeService documentTypeService;

	@Test
	public void probarSaveAll() {

		Long cantidadAlEmpezar = getDocumentTypeService().count();
		List<DocumentType> documentTypes = new ArrayList<DocumentType>();
		DocumentType documentTypePruebaB = new DocumentType();
		documentTypePruebaB.setDescription("pruebaB");
		documentTypes.add(documentTypePruebaB);

		DocumentType documentTypePruebaC = new DocumentType();
		documentTypePruebaC.setDescription("pruebaC");
		documentTypes.add(documentTypePruebaC);

		getDocumentTypeService().saveAll(documentTypes);
		getDocumentTypeService().delete(documentTypePruebaC);
		getDocumentTypeService().delete(documentTypePruebaB);
		assertEquals(getDocumentTypeService().count(), cantidadAlEmpezar + 0);
	}

	@Test
	public void findAll() {
		List<DocumentType> documentTypes = (List<DocumentType>) getDocumentTypeService().findAll();
		assertNotEquals(documentTypes.size(), 19);

	}

	@Test
	public void existsById() {

		DocumentType documentType = new DocumentType();
		documentType.setDescription("pruebaA");
		getDocumentTypeService().existsById(11);
		assertFalse(getDocumentTypeService().existsById(documentType.getId()));
	}

	@Test
	public void findAllById() {
		List<DocumentType> documentTypes = (List<DocumentType>) getDocumentTypeService().findAll();
		List<Integer> idsQueCompruebo = new ArrayList<Integer>();
		for (DocumentType documentTypeQueCompruebo : documentTypes) {
			idsQueCompruebo.add(documentTypeQueCompruebo.getId());
		}
		assertEquals(documentTypes.size(),
				((List<DocumentType>) getDocumentTypeService().findAllById(idsQueCompruebo)).size());
	}

	@Test
	public void Delete() {
		DocumentType documentType = new DocumentType();
		documentType.setDescription("pruebaD");
		getDocumentTypeService().save(documentType);

		int documentTypeId = documentType.getId();

		getDocumentTypeService().delete(documentType);

		assertNotNull(getDocumentTypeService().findById(documentTypeId));
	}

	@Test
	public void count() {

		List<DocumentType> documentTypes = new ArrayList<DocumentType>();
		DocumentType documentTypeA = new DocumentType();
		documentTypeA.setDescription("pruebaA");
		documentTypes.add(documentTypeA);

		DocumentType documentTypeB = new DocumentType();
		documentTypeB.setDescription("pruebaB");
		documentTypes.add(documentTypeB);

		long cantidad = documentTypeService.count();
		assertEquals(12, cantidad);
		documentTypes.forEach(documentType -> documentTypeService.deleteById(documentType.getId()));

	}

}
