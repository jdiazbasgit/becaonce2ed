package once.curso.proyectotienda.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.User;

@Repository
public interface UserCRUDRepository extends CrudRepository<User, Integer> {

}
