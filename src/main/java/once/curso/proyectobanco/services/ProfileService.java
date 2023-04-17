package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.Profile;
import once.curso.proyectobanco.repositories.ProfileCRUDRepository;

@Service
@Data
public class ProfileService {

	@Autowired
	private ProfileCRUDRepository profileCRUDRepository;

	public <S extends Profile> S save(S entity) {
		return getProfileCRUDRepository().save(entity);
	}

	public <S extends Profile> Iterable<S> saveAll(Iterable<S> entities) {
		return getProfileCRUDRepository().saveAll(entities);
	}

	public Optional<Profile> findById(Integer id) {
		return getProfileCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getProfileCRUDRepository().existsById(id);
	}

	public Iterable<Profile> findAll() {
		return getProfileCRUDRepository().findAll();
	}

	public Iterable<Profile> findAllById(Iterable<Integer> ids) {
		return getProfileCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getProfileCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getProfileCRUDRepository().deleteById(id);
	}

	public void delete(Profile entity) {
		getProfileCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getProfileCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Profile> entities) {
		getProfileCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getProfileCRUDRepository().deleteAll();
	}
}
