package once.curso.proyectotienda.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entitiies.Configuration;

@Repository
public interface configurationRepository extends CrudRepository<Configuration, Integer>{

	
	
	
}
