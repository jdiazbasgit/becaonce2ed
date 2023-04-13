package once.curso.proyectobanco.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import once.curso.proyectobanco.entities.TypeAccount;

public interface TypeAccountCRUDRepository extends CrudRepository<TypeAccount, Integer> {

	

}
