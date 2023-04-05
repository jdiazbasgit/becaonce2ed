package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.Configuration;


@Repository
public interface ConfigurationRepository extends CrudRepository<Configuration, Integer> {
	
}
