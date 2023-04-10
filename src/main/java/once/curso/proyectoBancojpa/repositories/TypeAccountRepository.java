package once.curso.proyectoBancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectoBancojpa.entities.TypeAccount;


@Repository
public interface TypeAccountRepository extends CrudRepository<TypeAccount, Integer> {

}
