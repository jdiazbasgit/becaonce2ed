package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.DocumentType;

@Repository
public interface DocumentTypeRepository extends CrudRepository<DocumentType, Integer> {

}
