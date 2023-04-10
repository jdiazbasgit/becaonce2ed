package once.curso.proyectoBancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectoBancojpa.entities.AwardFine;

@Repository
public interface AwardFineRepository extends CrudRepository<AwardFine, Integer> {

}
