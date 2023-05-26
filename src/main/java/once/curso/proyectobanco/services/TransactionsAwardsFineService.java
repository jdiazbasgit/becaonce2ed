package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.Configuration;
import once.curso.proyectobanco.entities.TransactionsAwardsFine;
import once.curso.proyectobanco.repositories.TransactionsAwardsFineRepository;

@Data
@Service
public class TransactionsAwardsFineService {
	
	@Autowired
	private TransactionsAwardsFineRepository transactionsAwardsFineRepository;
	
	
	public TransactionsAwardsFine save(TransactionsAwardsFine entity) {
		return getTransactionsAwardsFineRepository().save(entity);
	}

	public  Iterable<TransactionsAwardsFine> saveAll(Iterable<TransactionsAwardsFine> entities) {
		return getTransactionsAwardsFineRepository().saveAll(entities);
	}

	public Optional<TransactionsAwardsFine> findById(Integer id) {
		return getTransactionsAwardsFineRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getTransactionsAwardsFineRepository().existsById(id);
	}
	
	public Iterable<TransactionsAwardsFine> findAll() {
		return getTransactionsAwardsFineRepository().findAll();
	}

	public Page<TransactionsAwardsFine> findAll(Pageable pageable) {
		return getTransactionsAwardsFineRepository().findAll(pageable);
	}

	public Iterable<TransactionsAwardsFine> findAllById(Iterable<Integer> ids) {
		return getTransactionsAwardsFineRepository().findAllById(ids);
	}

	public long count() {
		return  getTransactionsAwardsFineRepository().count();
	}

	public void deleteById(Integer id) {
		getTransactionsAwardsFineRepository().deleteById(id);
	}

	public void delete(TransactionsAwardsFine entity) {
		getTransactionsAwardsFineRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getTransactionsAwardsFineRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends TransactionsAwardsFine> entities) {
		getTransactionsAwardsFineRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getTransactionsAwardsFineRepository().deleteAll();
	}
	
	

}
