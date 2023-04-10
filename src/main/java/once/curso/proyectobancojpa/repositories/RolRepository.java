package once.curso.proyectobancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobancojpa.entities.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {

}
