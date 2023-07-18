package once.curso.proyectobanco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.MappingFKDescription;

@Repository
public interface MappingFKDescriptionCRUDRepository extends CrudRepository<MappingFKDescription, Integer> {
	

	@Query(value = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'BANCO' AND table_type = 'BASE TABLE'", nativeQuery = true)
	public List<String> getTables();
	
}
