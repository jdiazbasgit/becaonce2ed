package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.Transaction;
import once.curso.proyectobanco.repositories.TransactionCRUDRepository;

@Data
@Service

//fecha
public class TransactionService {
	
	@Autowired
	private TransactionCRUDRepository transactionCRUDRepository;
	
	public void dameTransaccion() {
		Iterable<Transaction> transaccion = getTransactionCRUDRepository().findAll();
	}
	public <S extends Transaction> S save(S entity) {
		return getTransactionCRUDRepository().save(entity);
	}

	public <S extends Transaction> Iterable<S> saveAll(Iterable<S> entities) {
		return getTransactionCRUDRepository().saveAll(entities);
	}

	public Optional<Transaction> findById(Integer id) {
		return getTransactionCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getTransactionCRUDRepository().existsById(id);
	}

	public Iterable<Transaction> findAll() {
		return getTransactionCRUDRepository().findAll();
	}

	public Iterable<Transaction> findAllById(Iterable<Integer> ids) {
		return getTransactionCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getTransactionCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getTransactionCRUDRepository().deleteById(id);
	}

	public void delete(Transaction entity) {
		getTransactionCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getTransactionCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Transaction> entities) {
		getTransactionCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getTransactionCRUDRepository().deleteAll();
	}

}