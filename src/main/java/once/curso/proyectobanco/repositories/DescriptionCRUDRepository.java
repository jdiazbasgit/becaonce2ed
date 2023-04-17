package once.curso.proyectobanco.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import once.curso.proyectobanco.entities.Description;

public interface DescriptionCRUDRepository extends CrudRepository<Description, Integer> {

	

}
