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
	public RolCRUDRepository rolesCRUDRepository;

	public Rol save(Rol entity) {
		return getRolesCRUDRepository().save(entity);
	}

	public Iterable<Rol> saveAll(Iterable<Rol> entities) {
		return getRolesCRUDRepository().saveAll(entities);
	}

	public Optional<Rol> findById(Integer id) {
		return getRolesCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getRolesCRUDRepository().existsById(id);
	}

	public Iterable<Rol> findAll() {
		return getRolesCRUDRepository().findAll();
	}

	public Iterable<Rol> findAllById(Iterable<Integer> ids) {
		return getRolesCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getRolesCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getRolesCRUDRepository().deleteById(id);
	}

	public void delete(Rol entity) {
		getRolesCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getRolesCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Rol> entities) {
		getRolesCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getRolesCRUDRepository().deleteAll();
	}
}
