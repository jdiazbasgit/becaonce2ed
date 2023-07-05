package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.TransactionAwardFine;
import once.curso.proyectobanco.repositories.TransactionsAwardsFineCRUDRepository;

@Data
@Service
public class TransactionAwardFineService {
	
	@Autowired
	private TransactionsAwardsFineCRUDRepository transactionsAwardsFineRepository;
	
	
	public TransactionAwardFine save(TransactionAwardFine entity) {
		return getTransactionsAwardsFineRepository().save(entity);
	}

	public  Iterable<TransactionAwardFine> saveAll(Iterable<TransactionAwardFine> entities) {
		return getTransactionsAwardsFineRepository().saveAll(entities);
	}

	public Optional<TransactionAwardFine> findById(Integer id) {
		return getTransactionsAwardsFineRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getTransactionsAwardsFineRepository().existsById(id);
	}
	
	public Iterable<TransactionAwardFine> findAll() {
		return getTransactionsAwardsFineRepository().findAll();
	}

	public Page<TransactionAwardFine> findAll(Pageable pageable) {
		return getTransactionsAwardsFineRepository().findAll(pageable);
	}

	public Iterable<TransactionAwardFine> findAllById(Iterable<Integer> ids) {
		return getTransactionsAwardsFineRepository().findAllById(ids);
	}

	public long count() {
		return  getTransactionsAwardsFineRepository().count();
	}

	public void deleteById(Integer id) {
		getTransactionsAwardsFineRepository().deleteById(id);
	}

	public void delete(TransactionAwardFine entity) {
		getTransactionsAwardsFineRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getTransactionsAwardsFineRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends TransactionAwardFine> entities) {
		getTransactionsAwardsFineRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getTransactionsAwardsFineRepository().deleteAll();
	}
	
	

}
