package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.Rol;


@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {

}
