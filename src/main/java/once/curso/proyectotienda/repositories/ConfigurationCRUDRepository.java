package once.curso.proyectotienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.Configuration;

@Repository
public interface ConfigurationCRUDRepository extends CrudRepository<Configuration, Integer> {

	
	
}
