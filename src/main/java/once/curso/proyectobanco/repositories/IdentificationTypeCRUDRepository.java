package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import once.curso.proyectobanco.entities.IdentificationType;

@Repository
public interface IdentificationTypeCRUDRepository extends CrudRepository<IdentificationType, Integer> {

}
