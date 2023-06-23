package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
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

	/*@Test
	public void count() {

		List<DocumentType> documentTypes = new ArrayList<DocumentType>();
		DocumentType documentTypeA = new DocumentType();
		documentTypeA.setDescription("pruebaA");
		documentTypes.add(documentTypeA);

		DocumentType documentTypeB = new DocumentType();
		documentTypeB.setDescription("pruebaB");
		documentTypes.add(documentTypeB);

		int cantidad = (int) getDocumentTypeService().count();
		assertEquals(cantidad, 8);
		 documentTypes.forEach(documentType ->
		 documentTypeService.deleteById(documentType.getId()));

	}*/
	@Test
	public void count() {
	    int cantidadAlEmpezar = (int) getDocumentTypeService().count();
	    
	    List<DocumentType> documentTypes = new ArrayList<DocumentType>();
	    DocumentType documentTypeA = new DocumentType();
	    documentTypeA.setDescription("pruebaA");
	    documentTypes.add(documentTypeA);

	    DocumentType documentTypeB = new DocumentType();
	    documentTypeB.setDescription("pruebaB");
	    documentTypes.add(documentTypeB);

	    getDocumentTypeService().saveAll(documentTypes);
	    
	    int cantidadActual = (int) getDocumentTypeService().count();
	    int cantidadEsperada = cantidadAlEmpezar + documentTypes.size();
	    
	    assertEquals(cantidadActual, cantidadEsperada);
	    
	    documentTypes.forEach(documentType -> getDocumentTypeService().delete(documentType));
	}

	@Test
	public void save() {

		DocumentType documentType = new DocumentType();
		documentType.setDescription("pruebaC");
		getDocumentTypeService().save(documentType);

		DocumentType dTypeRecuperado = getDocumentTypeService().findById(documentType.getId()).get();
		getDocumentTypeService().delete(dTypeRecuperado);
		assertNotNull(getDocumentTypeService().findById(documentType.getId()));

	}

	@Test
	public void findById() {

		DocumentType documentType = new DocumentType();
		documentType.setDescription("pruebaD");
		getDocumentTypeService().save(documentType);

		DocumentType dTypeRecuperado = getDocumentTypeService().findById(documentType.getId()).orElse(null);
		assertNotNull(getDocumentTypeService().findById(documentType.getId()));

		getDocumentTypeService().delete(dTypeRecuperado);
		 assertNotNull(getDocumentTypeService().findById(documentType.getId()));

	}

}
