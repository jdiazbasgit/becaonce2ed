package once.curso.proyectobancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobancojpa.entities.Description;


@Repository
public interface DescriptionRepository extends CrudRepository<Description, Integer>{
	
}
