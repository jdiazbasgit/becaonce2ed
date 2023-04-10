package once.curso.proyectoBancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectoBancojpa.entities.AwardFineType;

@Repository
public interface AwardFineTypeRepository extends CrudRepository<AwardFineType, Integer> {

}
