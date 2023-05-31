package once.curso.proyectobanco.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {


	
}
