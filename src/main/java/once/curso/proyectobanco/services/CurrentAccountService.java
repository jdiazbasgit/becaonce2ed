package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.CurrentAccount;
import once.curso.proyectobanco.repositories.CurrentAccountCRUDRepository;

@Data
@Service
public class CurrentAccountService {
	@Autowired
	private CurrentAccountCRUDRepository accountCRUDRepository;
	
	public void dameCuenta() {
		Iterable<CurrentAccountCRUDRepository> cuenta= getAccountCRUDRepository().findAll();
	
	}

	public <S extends CurrentAccountCRUDRepository> S save(S entity) {
		return getAccountCRUDRepository().save(entity);
		
	}

	public <S extends CurrentAccountCRUDRepository> Iterable<S> saveAll(Iterable<S> entities) {
		return getAccountCRUDRepository().saveAll(entities);
	}

	public Optional<CurrentAccountCRUDRepository> findById(Integer id) {
		return getAccountCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getAccountCRUDRepository().existsById(id);
	}

	public Iterable<CurrentAccountCRUDRepository> findAll() {
		return getAccountCRUDRepository().findAll();
	}

	public Iterable<CurrentAccountCRUDRepository> findAllById(Iterable<Integer> ids) {
		return getAccountCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getAccountCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getAccountCRUDRepository().deleteById(id);
	}

	public void delete(CurrentAccountCRUDRepository entity) {
		getAccountCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getAccountCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends CurrentAccountCRUDRepository> entities) {
		getAccountCRUDRepository().deleteAll(entities);;
	}

	public void deleteAll() {
		getAccountCRUDRepository().deleteAll();
	}


	
}
