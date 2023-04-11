package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {

}
