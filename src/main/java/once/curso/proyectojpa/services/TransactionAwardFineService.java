package once.curso.proyectojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectojpa.entities.TransactionAwardFine;
import once.curso.proyectojpa.repositories.TransactionAwardFineRepository;

@Service
@Data
public class TransactionAwardFineService {

	@Autowired
	private TransactionAwardFineRepository transactionAwardFineRepository;

	public void dameTransactiones() {

		Iterable<TransactionAwardFine> Transactiones = getTransactionAwardFineRepository().findAll();
		for (TransactionAwardFine transactionAwardFine : Transactiones) {
			System.out.println(transactionAwardFine.getTransaction());
			System.out.println(transactionAwardFine.getAwardFineType());
		}

	}

	public <S extends TransactionAwardFine> S save(S entity) {

		return getTransactionAwardFineRepository().save(entity);
	}

	public <S extends TransactionAwardFine> Iterable<S> saveAll(Iterable<S> entities) {

		return getTransactionAwardFineRepository().saveAll(entities);
	}

	public Optional<TransactionAwardFine> findById(Integer id) {

		return getTransactionAwardFineRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getTransactionAwardFineRepository().existsById(id);
	}

	public Iterable<TransactionAwardFine> findAll() {

		return getTransactionAwardFineRepository().findAll();
	}

	public Iterable<TransactionAwardFine> findAllById(Iterable<Integer> ids) {

		return getTransactionAwardFineRepository().findAllById(ids);
	}

	public long count() {

		return getTransactionAwardFineRepository().count();
	}

	public void deleteById(Integer id) {
		getTransactionAwardFineRepository().deleteById(id);

	}

	public void delete(TransactionAwardFine entity) {
		getTransactionAwardFineRepository().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getTransactionAwardFineRepository().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends TransactionAwardFine> entities) {
		getTransactionAwardFineRepository().deleteAll(entities);

	}

	public void deleteAll() {
		getTransactionAwardFineRepository().deleteAll();

	}
}
