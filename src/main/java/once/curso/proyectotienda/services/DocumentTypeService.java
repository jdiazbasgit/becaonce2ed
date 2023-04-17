package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;
import once.curso.proyectotienda.entities.DocumentType;
import once.curso.proyectotienda.repositories.DocumentTypeCRUDRepository;

@Data
@Service
public class DocumentTypeService {

	@Autowired
	private DocumentTypeCRUDRepository documentTypeCRUDRepository;

	public void dameTiposDeDocumentos() {

		Iterable<DocumentType> dameTipoDeDocumentos = getDocumentTypeCRUDRepository().findAll();
		for (DocumentType documentType : dameTipoDeDocumentos) {
			System.out.println(documentType.getId());
			System.out.println(documentType.getDescription());
		}

	}

	public <S extends DocumentType> S save(S entity) {
		return getDocumentTypeCRUDRepository().save(entity);
	}

	public <S extends DocumentType> Iterable<S> saveAll(Iterable<S> entities) {
		return getDocumentTypeCRUDRepository().saveAll(entities);
	}

	public Optional<DocumentType> findById(Integer id) {
		return getDocumentTypeCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getDocumentTypeCRUDRepository().existsById(id);
	}

	public Iterable<DocumentType> findAll() {
		return getDocumentTypeCRUDRepository().findAll();
	}

	public Iterable<DocumentType> findAllById(Iterable<Integer> ids) {
		return getDocumentTypeCRUDRepository().findAllById(ids);

	}

	public long count() {
		return getDocumentTypeCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getDocumentTypeCRUDRepository().deleteById(id);
	}

	public void delete(DocumentType entity) {
		getDocumentTypeCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getDocumentTypeCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends DocumentType> entities) {
		getDocumentTypeCRUDRepository().deleteAll();
	}

	public void deleteAll() {
		getDocumentTypeCRUDRepository().deleteAll();
	}
}
