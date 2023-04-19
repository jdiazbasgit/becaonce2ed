package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

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

	/*@Test
	public void probarSaveFindDelete() {

		DocumentType documentType = new DocumentType();
		documentType.setDescription("pruebaA");
		getDocumentTypeService().save(documentType);

		DocumentType documentTypeRecuperado = getDocumentTypeService().findById(documentType.getId()).get();
		getDocumentTypeService().delete(documentTypeRecuperado);

		assertFalse(getDocumentTypeService().existsById(documentType.getId()));
	}*/

	public void probarSaveAllDeleteAll() {

		Long cantidadAlEmpezar = getDocumentTypeService().count();
		List<DocumentType> documentTypes = new ArrayList<DocumentType>();
		DocumentType documentTypePruebaB = new DocumentType();
		documentTypePruebaB.setDescription("pruebaB");
		documentTypes.add(documentTypePruebaB);

		DocumentType documentTypePruebaC = new DocumentType();
		documentTypePruebaC.setDescription("pruebaC");
		documentTypes.add(documentTypePruebaC);

		getDocumentTypeService().saveAll(documentTypes);
		assertEquals(getDocumentTypeService().count(), cantidadAlEmpezar + 4);
	}
}
