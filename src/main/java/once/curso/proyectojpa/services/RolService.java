package once.curso.proyectojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectojpa.entities.Rol;
import once.curso.proyectojpa.repositories.RolRepository;

@Service
@Data
public class RolService {

	@Autowired
	private RolRepository rolRepository;

	public void dameRoles() {

		Iterable<Rol> roles = getRolRepository().findAll();
		for (Rol rol : roles) {
			System.out.println(rol.getRol());
		}
	}

	public <S extends Rol> S save(S entity) {

		return getRolRepository().save(entity);
	}

	public <S extends Rol> Iterable<S> saveAll(Iterable<S> entities) {

		return getRolRepository().saveAll(entities);
	}

	public Optional<Rol> findById(Integer id) {

		return getRolRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getRolRepository().existsById(id);
	}

	public Iterable<Rol> findAll() {

		return getRolRepository().findAll();
	}

	public Iterable<Rol> findAllById(Iterable<Integer> ids) {

		return getRolRepository().findAllById(ids);
	}

	public long count() {

		return getRolRepository().count();
	}

	public void deleteById(Integer id) {
		getRolRepository().deleteById(id);

	}

	public void delete(Rol entity) {
		getRolRepository().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getRolRepository().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends Rol> entities) {
		getRolRepository().deleteAll(entities);

	}

	public void deleteAll() {
		getRolRepository().deleteAll();

	}
}
