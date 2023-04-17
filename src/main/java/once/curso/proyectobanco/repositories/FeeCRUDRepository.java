package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import once.curso.proyectobanco.entities.Fee;

@Repository
public interface FeeCRUDRepository extends CrudRepository<Fee, Integer> {

}
