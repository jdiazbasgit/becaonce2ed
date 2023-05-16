package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.Rol;
import once.curso.proyectotienda.repositories.RolCRUDRepository;

@Service
@Data
public class RolService {
	
	@Autowired
	private RolCRUDRepository rolesCRUDRepository;
	
	public <S extends Rol> S save(S entity) {
		// orden 5, prueba hecha
		return getRolesCRUDRepository().save(entity);
	}

	public <S extends Rol> Iterable<S> saveAll(Iterable<S> entities) {
		// orden 6
		return getRolesCRUDRepository().saveAll(entities);
	}

	public Optional<Rol> findById(Integer id) {
		// orden 1, prueba hecha
		return getRolesCRUDRepository().findById(id);
	}

	// NEW
	public Optional<Rol> findByRol(String rol) {
		// orden 4, prueba hecha
		return getRolesCRUDRepository().findByRol(rol);
	}

	public boolean existsById(Integer id) {
		// orden 7
		return getRolesCRUDRepository().existsById(id);
	}

	public Iterable<Rol> findAll() {
		// orden 2
		return getRolesCRUDRepository().findAll();
	}

	public Iterable<Rol> findAllById(Iterable<Integer> ids) {
		// orden 3
		return getRolesCRUDRepository().findAllById(ids);
	}

	public long count() {
		// orden 8
		return getRolesCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		// orden 9
		getRolesCRUDRepository().deleteById(id);
	}

	public void delete(Rol entity) {
		// orden 10
		getRolesCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		// orden 11
		getRolesCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Rol> entities) {
		// orden 12
		getRolesCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		// orden 13
		getRolesCRUDRepository().deleteAll();
	}
}
