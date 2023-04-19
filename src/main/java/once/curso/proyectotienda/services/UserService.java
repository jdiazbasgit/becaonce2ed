package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.User;
import once.curso.proyectotienda.repositories.UserCRUDRepository;

@Service
@Data
public class UserService {

	@Autowired
	private UserCRUDRepository userCRUDRepository;
	
	
	public User save(User entity) {

		return getUserCRUDRepository().save(entity);
	}

	public Iterable<User> saveAll(Iterable<User> entities) {

		return getUserCRUDRepository().saveAll(entities);
	}

	public Optional<User> findById(Integer id) {

		return getUserCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getUserCRUDRepository().existsById(id);
	}

	public Iterable<User> findAll() {

		return getUserCRUDRepository().findAll();
	}

	public Iterable<User> findAllById(Iterable<Integer> ids) {

		return getUserCRUDRepository().findAllById(ids);
	}

	public long count() {

		return getUserCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getUserCRUDRepository().deleteById(id);
	}

	public void delete(User entity) {
		getUserCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getUserCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends User> entities) {
		getUserCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getUserCRUDRepository().deleteAll();
	}
}


