package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.repositories.ProfileCRUDRepository;

@Service
@Data
public class ProfileService {
	@Autowired
	private ProfileCRUDRepository profilesCRUDRepository;
	
	public Profile save(Profile entity) {
		return getProfilesCRUDRepository().save(entity);
	}
	
	public Iterable<Profile> saveAll(Iterable<Profile> entities) {
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
	
	public void deleteAll(Iterable<? extends Profile> entities) {
		getProfilesCRUDRepository().deleteAll(entities);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		for (Integer id : ids){
			getProfilesCRUDRepository().deleteById(id);
		}
	}

	public void deleteAll() {
		getProfilesCRUDRepository().deleteAll();
	}
}
