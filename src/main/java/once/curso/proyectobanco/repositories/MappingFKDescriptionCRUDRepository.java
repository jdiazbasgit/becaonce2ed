package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.MappingFKDescription;

@Repository
public interface MappingFKDescriptionCRUDRepository extends CrudRepository<MappingFKDescription, Integer> {

}
