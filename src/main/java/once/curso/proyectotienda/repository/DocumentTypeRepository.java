package once.curso.proyectotienda.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entitiies.DocumentType;


@Repository
public interface DocumentTypeRepository extends CrudRepository<DocumentType, Integer> {

	
	

}
