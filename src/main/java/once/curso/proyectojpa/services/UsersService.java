package once.curso.proyectojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectojpa.entities.Users;
import once.curso.proyectojpa.repositories.UsersRepository;

@Data
@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	public void dameClientes() {

		Iterable<Users> dameClientes = getUsersRepository().findAll();
		for (Users users : dameClientes) {

			System.out.println(users.getId());
			System.out.println(users.getUser());
			System.out.println(users.getPassword());
			System.out.println(users.getRol());
			System.out.println(users.getEnabled());
		}

	}

	public <S extends Users> S save(S entity) {
		return getUsersRepository().save(entity);
	}

	public <S extends Users> Iterable<S> saveAll(Iterable<S> entities) {
		return getUsersRepository().saveAll(entities);
	}

	public Optional<Users> findById(Integer id) {
		return getUsersRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getUsersRepository().existsById(id);
	}

	public Iterable<Users> findAll() {
		return getUsersRepository().findAll();
	}

	public Iterable<Users> findAllById(Iterable<Integer> ids) {
		return getUsersRepository().findAllById(ids);
	}

	public long count() {
		return getUsersRepository().count();
	}

	public void deleteById(Integer id) {
		getUsersRepository().deleteById(id);
	}

	public void delete(Users entity) {
		getUsersRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getUsersRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Users> entities) {
		getUsersRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getUsersRepository().deleteAll();
	}

}
