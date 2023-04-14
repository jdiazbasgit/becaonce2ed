package once.curso.proyectobanco.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.Rol;


@Repository
public interface RolRepository extends CrudRepository<Rol,Integer> {

	
	

}
