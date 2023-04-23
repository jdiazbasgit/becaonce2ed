package once.curso.proyectotienda.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.Rol;

@Repository
public interface RolCRUDRepository extends CrudRepository<Rol, Integer> {

	// NEW
	public Optional<Rol> findByRol(String rol);
	
}
