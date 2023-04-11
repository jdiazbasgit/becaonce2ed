package once.curso.proyectojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectojpa.entities.DocumentType;
import once.curso.proyectojpa.repositories.DocumentTypeRepository;

@Data
@Service
public class DocumentTypeService {

	@Autowired
	private DocumentTypeRepository documentTypeRepository;

	public void dameTipoDocumentos() {

		Iterable<DocumentType> dameTipoDocumentos = getDocumentTypeRepository().findAll();
		for (DocumentType documentType : dameTipoDocumentos) {
			System.out.println(documentType.getDescription());
		}

	}

	public <S extends DocumentType> S save(S entity) {
		return getDocumentTypeRepository().save(entity);
	}

	public <S extends DocumentType> Iterable<S> saveAll(Iterable<S> entities) {
		return getDocumentTypeRepository().saveAll(entities);
	}

	public Optional<DocumentType> findById(Integer id) {
		return getDocumentTypeRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getDocumentTypeRepository().existsById(id);
	}

	public Iterable<DocumentType> findAll() {
		return getDocumentTypeRepository().findAll();
	}

	public Iterable<DocumentType> findAllById(Iterable<Integer> ids) {
		return getDocumentTypeRepository().findAllById(ids);
	}

	public long count() {
		return getDocumentTypeRepository().count();
	}

	public void deleteById(Integer id) {
		getDocumentTypeRepository().deleteById(id);

	}

	public void delete(DocumentType entity) {
		getDocumentTypeRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getDocumentTypeRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends DocumentType> entities) {
		getDocumentTypeRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getDocumentTypeRepository().deleteAll();
	}

}
