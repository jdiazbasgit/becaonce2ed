package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.TypeAccount;


@Repository
public interface TypeAccountRepository extends CrudRepository<TypeAccount, Integer> {

}
