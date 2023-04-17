package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.Rol;
import once.curso.proyectobanco.repositories.RolCRUDRepository;

@Data
@Service
//fecha
public class RolService {
	
	@Autowired
	private RolCRUDRepository rolCRUDRepository;
	
	public Iterable<Rol> dameRoles() {
		return getRolCRUDRepository().findAll();
	}
	public <S extends Rol> S save(S entity) {
		return getRolCRUDRepository().save(entity);
	}

	public <S extends Rol> Iterable<S> saveAll(Iterable<S> entities) {
		return getRolCRUDRepository().saveAll(entities);
	}

	public Optional<Rol> findById(Integer id) {
		return getRolCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getRolCRUDRepository().existsById(id);
	}

	public Iterable<Rol> findAll() {
		return getRolCRUDRepository().findAll();
	}

	public Iterable<Rol> findAllById(Iterable<Integer> ids) {
		return getRolCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getRolCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getRolCRUDRepository().deleteById(id);
	}

	public void delete(Rol entity) {
		getRolCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getRolCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Rol> entities) {
		getRolCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getRolCRUDRepository().deleteAll();
	}
}
