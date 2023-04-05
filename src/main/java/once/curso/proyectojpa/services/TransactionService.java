package once.curso.proyectojpa.services;

import java.util.Optional;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectojpa.repositories.TransactionRepository;

@Service
@Data
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public void dameTransactions() {

		Iterable<Transaction> transactions = getTransactionRepository().findAll();
		for (Transaction transaction : transactions) {
			System.out.println(transaction.getClass());
		}

	}

	public <S extends Transaction> S save(S entity) {

		return getTransactionRepository().save(entity);
	}

	public <S extends Transaction> Iterable<S> saveAll(Iterable<S> entities) {

		return getTransactionRepository().saveAll(entities);
	}

	public Optional<Transaction> findById(Integer id) {

		return getTransactionRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getTransactionRepository().existsById(id);
	}

	public Iterable<Transaction> findAll() {

		return getTransactionRepository().findAll();
	}

	public Iterable<Transaction> findAllById(Iterable<Integer> ids) {

		return getTransactionRepository().findAllById(ids);
	}

	public long count() {

		return getTransactionRepository().count();
	}

	public void deleteById(Integer id) {
		getTransactionRepository().deleteById(id);

	}

	public void delete(Transaction entity) {
		getTransactionRepository().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getTransactionRepository().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends Transaction> entities) {
		getTransactionRepository().deleteAll(entities);

	}

	public void deleteAll() {
		getTransactionRepository().deleteAll();

	}
}
