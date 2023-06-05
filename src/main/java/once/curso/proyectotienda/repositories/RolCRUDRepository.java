package once.curso.proyectotienda.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.Rol;

@Repository
public interface RolCRUDRepository extends PagingAndSortingRepository<Rol, Integer> {

	// NEW
	public Optional<Rol> findByRol(String rol);
	
	}
	

