package once.curso.proyectojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectojpa.entities.CurrentAccount;
import once.curso.proyectojpa.repositories.CurrentAccountRepository;

@Service
@Data
public class CurrentAccountService {

	@Autowired
	private CurrentAccountRepository currentAccountRepository;

	public void dameCuentasActuales() {

		Iterable<CurrentAccount> currenAccounts = getCurrentAccountRepository().findAll();
		for (CurrentAccount currentAccount : currenAccounts) {
			System.out.println(currentAccount.getFee());
		}
	}

	public <S extends CurrentAccount> S save(S entity) {

		return getCurrentAccountRepository().save(entity);
	}

	public <S extends CurrentAccount> Iterable<S> saveAll(Iterable<S> entities) {

		return getCurrentAccountRepository().saveAll(entities);
	}

	public Optional<CurrentAccount> findById(Integer id) {

		return getCurrentAccountRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getCurrentAccountRepository().existsById(id);
	}

	public Iterable<CurrentAccount> findAll() {

		return getCurrentAccountRepository().findAll();
	}

	public Iterable<CurrentAccount> findAllById(Iterable<Integer> ids) {

		return getCurrentAccountRepository().findAllById(ids);
	}

	public long count() {

		return getCurrentAccountRepository().count();
	}

	public void deleteById(Integer id) {
		getCurrentAccountRepository().deleteById(id);

	}

	public void delete(CurrentAccount entity) {
		getCurrentAccountRepository().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getCurrentAccountRepository().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends CurrentAccount> entities) {
		getCurrentAccountRepository().deleteAll(entities);

	}

	public void deleteAll() {
		getCurrentAccountRepository().deleteAll();

	}
}
