package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

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
	public void probarSaveFindDelete() {

		DocumentType documentType = new DocumentType();
		documentType.setDescription("prueba");
		getDocumentTypeService().save(documentType);

		DocumentType documentTypeRecuperado = getDocumentTypeService().findById(documentType.getId()).get();
		getDocumentTypeService().delete(documentTypeRecuperado);

		assertFalse(getDocumentTypeService().findById(documentType.getId()).isPresent());

		DocumentType documentTypeBorrado = getDocumentTypeService().findById(documentType.getId()).get();
		assertNull(documentTypeBorrado);
	}
}
