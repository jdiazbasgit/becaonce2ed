package once.curso.proyectoBancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectoBancojpa.entities.Configuration;


@Repository
public interface ConfigurationRepository extends CrudRepository<Configuration, Integer> {
	
}
