package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.Rol;
import once.curso.proyectobanco.entities.User;
import once.curso.proyectobanco.repositories.ProfileCRUDRepository;
import once.curso.proyectobanco.repositories.RolCRUDRepository;
import once.curso.proyectobanco.repositories.UserCRUDRepository;


@Data
@Service
public class UserService {
	
	@Autowired
	private UserCRUDRepository userCRUDRepository ;
	
	@Autowired
	private ProfileCRUDRepository profileCRUDRepository;
	
	@Autowired
	private RolCRUDRepository rolCRUDRepository;
	

	
	public <S extends User> S save(S entity) {
		return getUserCRUDRepository().save(entity);
	}

	public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
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
	
	public Page<User> findAll(Pageable pageable) {
		return getUserCRUDRepository().findAll(pageable);
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
	
	public User loadUserByUsername(String username) {
		return getUserCRUDRepository().loadUserByUsername(username);
	}


}
