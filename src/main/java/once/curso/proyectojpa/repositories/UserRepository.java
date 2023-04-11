package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
