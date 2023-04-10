package once.curso.proyectoBancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectoBancojpa.entities.Fee;


@Repository
public interface FeeRepository extends CrudRepository<Fee, Integer> {

}
