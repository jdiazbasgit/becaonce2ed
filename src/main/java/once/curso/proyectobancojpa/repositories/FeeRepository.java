package once.curso.proyectobancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobancojpa.entities.Fee;


@Repository
public interface FeeRepository extends CrudRepository<Fee, Integer> {

}
