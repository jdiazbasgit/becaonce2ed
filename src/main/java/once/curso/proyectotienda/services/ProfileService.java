package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entitypes.Profile;
import once.curso.proyectotienda.repositories.ProfileCRUDRepository;

@Service
@Data
public class ProfileService {
	private ProfileCRUDRepository profilesCRUDRepository;
	
	public <S extends Profile> S save(S entity) {
		return getProfilesCRUDRepository().save(entity);
	}

	public <S extends Profile> Iterable<S> saveAll(Iterable<S> entities) {
		return getProfilesCRUDRepository().saveAll(entities);
	}

	public Optional<Profile> findById(Integer id) {
		return getProfilesCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getProfilesCRUDRepository().existsById(id);
	}

	public Iterable<Profile> findAll() {
		return getProfilesCRUDRepository().findAll();
	}

	public Iterable<Profile> findAllById(Iterable<Integer> ids) {
		return getProfilesCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getProfilesCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getProfilesCRUDRepository().deleteById(id);
	}

	public void delete(Profile entity) {
		getProfilesCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getProfilesCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Profile> entities) {
		getProfilesCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getProfilesCRUDRepository().deleteAll();
	}
}
