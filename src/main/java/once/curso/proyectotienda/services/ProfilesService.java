package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entitypes.Profiles;
import once.curso.proyectotienda.repositories.ProfilesCRUDRepository;

@Service
@Data
public class ProfilesService {
	private ProfilesCRUDRepository profilesCRUDRepository;
	
	public <S extends Profiles> S save(S entity) {
		return getProfilesCRUDRepository().save(entity);
	}

	public <S extends Profiles> Iterable<S> saveAll(Iterable<S> entities) {
		return getProfilesCRUDRepository().saveAll(entities);
	}

	public Optional<Profiles> findById(Integer id) {
		return getProfilesCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getProfilesCRUDRepository().existsById(id);
	}

	public Iterable<Profiles> findAll() {
		return getProfilesCRUDRepository().findAll();
	}

	public Iterable<Profiles> findAllById(Iterable<Integer> ids) {
		return getProfilesCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getProfilesCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getProfilesCRUDRepository().deleteById(id);
	}

	public void delete(Profiles entity) {
		getProfilesCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getProfilesCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Profiles> entities) {
		getProfilesCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getProfilesCRUDRepository().deleteAll();
	}
}
