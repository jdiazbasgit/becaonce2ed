package once.curso.proyectobancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobancojpa.entities.Configuration;


@Repository
public interface ConfigurationRepository extends CrudRepository<Configuration, Integer> {
	
}
