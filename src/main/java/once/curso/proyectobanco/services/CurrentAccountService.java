package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.CurrentAccount;
import once.curso.proyectobanco.entities.Description;
import once.curso.proyectobanco.repositories.CurrentAccountCRUDRepository;

@Data
@Service
public class CurrentAccountService {
	@Autowired
	private CurrentAccountCRUDRepository currentAccountCRUDRepository;
	
	public Iterable<CurrentAccount>dameCuentas() {
		return getCurrentAccountCRUDRepository().findAll();
	
	}

	public <S extends CurrentAccount> S save(S entity) {
		return getCurrentAccountCRUDRepository().save(entity);
		
	}

	public <S extends CurrentAccount> Iterable<S> saveAll(Iterable<S> entities) {
		return getCurrentAccountCRUDRepository().saveAll(entities);
	}

	public Optional<CurrentAccount> findById(Integer id) {
		return getCurrentAccountCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getCurrentAccountCRUDRepository().existsById(id);
	}

	public Iterable<CurrentAccount> findAll() {
		return getCurrentAccountCRUDRepository().findAll();
	}
		
		public Page<CurrentAccount> findAll(Pageable pageable){
			return getCurrentAccountCRUDRepository().findAll(pageable);
		}
	

	public Iterable<CurrentAccount> findAllById(Iterable<Integer> ids) {
		return getCurrentAccountCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getCurrentAccountCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getCurrentAccountCRUDRepository().deleteById(id);
	}

	public void delete(CurrentAccount entity) {
		getCurrentAccountCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getCurrentAccountCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends CurrentAccount> entities) {
		getCurrentAccountCRUDRepository().deleteAll(entities);;
	}

	public void deleteAll() {
		getCurrentAccountCRUDRepository().deleteAll();
	}


	
}
