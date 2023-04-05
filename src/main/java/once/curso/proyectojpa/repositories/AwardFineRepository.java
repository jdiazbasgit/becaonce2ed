package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.AwardFine;

@Repository
public interface AwardFineRepository extends CrudRepository<AwardFine, Integer> {

}
