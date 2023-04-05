package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.Description;


@Repository
public interface DescriptionRepository extends CrudRepository<Description, Integer>{
	
}
