package once.curso.proyectoBancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectoBancojpa.entities.IdentificationType;


@Repository
public interface IdentificationTypeRepository extends CrudRepository<IdentificationType, Integer> {

}
