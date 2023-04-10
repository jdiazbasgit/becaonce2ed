package once.curso.proyectoBancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectoBancojpa.entities.Description;


@Repository
public interface DescriptionRepository extends CrudRepository<Description, Integer>{
	
}
