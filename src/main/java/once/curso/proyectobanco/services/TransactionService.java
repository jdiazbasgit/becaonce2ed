package once.curso.proyectobanco.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.Data;
import once.curso.proyectobanco.dtos.TransactionDto;
import once.curso.proyectobanco.entities.Transaction;
import once.curso.proyectobanco.repositories.CurrentAccountCRUDRepository;
import once.curso.proyectobanco.repositories.DescriptionCRUDRepository;
import once.curso.proyectobanco.repositories.TransactionCRUDRepository;

@Data
@Service

//fecha
public class TransactionService {
	
	@Autowired
	private CurrentAccountCRUDRepository currentAccountCRUDRepository;
	@Autowired
	private DescriptionCRUDRepository DescriptionCRUDRepository;
	
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

	public List<Transaction> getTransactionsByCurrentAccount(int number){
		return getTransactionCRUDRepository().getTransactionsByCurrentAccount(number);
		
	}
		
	
	public boolean existsById(Integer id) {
		return getTransactionCRUDRepository().existsById(id);
	}

	public Iterable<Transaction> findAll() {
		return getTransactionCRUDRepository().findAll();
	}
	public Page<Transaction>findAll(Pageable pageable){
		return getTransactionCRUDRepository().findAll(pageable);
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
@Transactional
public Transaction verConcepto(TransactionDto transactionDto) {
	Transaction transaction= new Transaction();
	transaction.setId(transaction.getId());
	transaction.setDate(transaction.getDate());
	transaction.setCurrent(transaction.getCurrent());
	transaction.setDescription(getDescriptionCRUDRepository().findById(transactionDto.getDescriptionId()).get());
	transaction.setCurrentAccount(getCurrentAccountCRUDRepository().findById(transactionDto.getCurrentAccountId()).get());
	
	
	return verConcepto(transactionDto);
}




}
