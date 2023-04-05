package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.IdentificationType;


@Repository
public interface IdentificationTypeRepository extends CrudRepository<IdentificationType, Integer> {

}
