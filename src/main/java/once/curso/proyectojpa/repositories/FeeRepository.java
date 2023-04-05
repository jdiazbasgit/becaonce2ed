package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.Fee;


@Repository
public interface FeeRepository extends CrudRepository<Fee, Integer> {

}
