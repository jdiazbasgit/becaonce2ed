package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.Rol;
import once.curso.proyectotienda.repositories.RolCRUDRepository;

@Service
@Data
public class RolService {
	private RolCRUDRepository rolesCRUDRepository;

	private <S extends Rol> S save(S entity) {
		return getRolesCRUDRepository().save(entity);
	}

	private <S extends Rol> Iterable<S> saveAll(Iterable<S> entities) {
		return getRolesCRUDRepository().saveAll(entities);
	}

	private Optional<Rol> findById(Integer id) {
		return getRolesCRUDRepository().findById(id);
	}

	private boolean existsById(Integer id) {
		return getRolesCRUDRepository().existsById(id);
	}

	private Iterable<Rol> findAll() {
		return getRolesCRUDRepository().findAll();
	}

	private Iterable<Rol> findAllById(Iterable<Integer> ids) {
		return getRolesCRUDRepository().findAllById(ids);
	}

	private long count() {
		return getRolesCRUDRepository().count();
	}

	private void deleteById(Integer id) {
		getRolesCRUDRepository().deleteById(id);
	}

	private void delete(Rol entity) {
		getRolesCRUDRepository().delete(entity);
	}

	private void deleteAllById(Iterable<? extends Integer> ids) {
		getRolesCRUDRepository().deleteAllById(ids);
	}

	private void deleteAll(Iterable<? extends Rol> entities) {
		getRolesCRUDRepository().deleteAll(entities);
	}

	private void deleteAll() {
		getRolesCRUDRepository().deleteAll();
	}
}
