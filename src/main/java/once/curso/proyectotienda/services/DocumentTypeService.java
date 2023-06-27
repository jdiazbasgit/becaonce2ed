package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.DocumentType;
import once.curso.proyectotienda.repositories.DocumentTypeCRUDRepository;

@Data
@Service
public class DocumentTypeService {

	@Autowired
	private DocumentTypeCRUDRepository documentTypeCRUDRepository;

	public Iterable<DocumentType> getDocumentType(){
		return getDocumentTypeCRUDRepository().findAll();
	}

	public  DocumentType save(DocumentType entity) {
		return getDocumentTypeCRUDRepository().save(entity);
	}

	public Iterable<DocumentType> saveAll(Iterable<DocumentType> entities) {
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

	public Page<DocumentType> findAll(Pageable pageable){
		return getDocumentTypeCRUDRepository().findAll(pageable);
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
