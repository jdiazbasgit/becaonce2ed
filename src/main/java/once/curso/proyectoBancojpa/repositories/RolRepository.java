package once.curso.proyectoBancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectoBancojpa.entities.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {

}
