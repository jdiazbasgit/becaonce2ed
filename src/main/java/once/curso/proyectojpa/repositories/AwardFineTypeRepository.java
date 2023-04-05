package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.AwardFineType;

@Repository
public interface AwardFineTypeRepository extends CrudRepository<AwardFineType, Integer> {

}
