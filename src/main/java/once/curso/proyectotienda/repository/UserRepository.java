package once.curso.proyectotienda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
