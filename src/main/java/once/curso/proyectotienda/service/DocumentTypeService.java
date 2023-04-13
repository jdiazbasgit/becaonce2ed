package once.curso.proyectotienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entitiies.DocumentType;
import once.curso.proyectotienda.repository.DocumentTypeRepository;

@Data
@Service
public class DocumentTypeService {

	@Autowired
	private DocumentTypeRepository documentTypeRepository;

	public void dameTipoDocumentos() {

		Iterable<DocumentType> dameTipoDocumentos = getDocumentTypeRepository().findAll();
		for (DocumentType documentType : dameTipoDocumentos) {
			System.out.println(documentType.getId());
			System.out.println(documentType.getDescription());
		}
	}

	public <S extends DocumentType> S save(S entity) {
		return null;
	}

	public <S extends DocumentType> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}

	public Optional<DocumentType> findById(Integer id) {
		return null;
	}

	public boolean existsById(Integer id) {
		return false;
	}

	public Iterable<DocumentType> findAll() {
		return null;
	}

	public Iterable<DocumentType> findAllById(Iterable<Integer> ids) {
		return null;
	}

	public long count() {
		return 0;
	}

	public void deleteById(Integer id) {

	}

	public void delete(DocumentType entity) {

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {

	}

	public void deleteAll(Iterable<? extends DocumentType> entities) {

	}

	public void deleteAll() {

	}

}
