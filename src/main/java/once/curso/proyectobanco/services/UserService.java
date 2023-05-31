package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.User;
import once.curso.proyectobanco.repositories.UserCRUDRepository;


@Data
@Service
public class UserService {
	
	@Autowired
	private UserCRUDRepository repository;
	
	
	public <S extends User> S save(S entity) {
		return getRepository().save(entity);
	}

	public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
		return getRepository().saveAll(entities);
	}

	public Optional<User> findById(Integer id) {
		return getRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getRepository().existsById(id);
	}

	public Iterable<User> findAll() {
		return getRepository().findAll();
	}

	public Iterable<User> findAllById(Iterable<Integer> ids) {
		return getRepository().findAllById(ids);
	}

	public long count() {
		return getRepository().count();
	}

	public void deleteById(Integer id) {
		getRepository().deleteById(id);
	}

	public void delete(User entity) {
		getRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends User> entities) {
		getRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getRepository().deleteAll();
	}


}
