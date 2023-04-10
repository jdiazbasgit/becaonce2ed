package once.curso.proyectobancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobancojpa.entities.IdentificationType;


@Repository
public interface IdentificationTypeRepository extends CrudRepository<IdentificationType, Integer> {

}
