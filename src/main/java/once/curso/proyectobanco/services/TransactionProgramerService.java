package once.curso.proyectobanco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.TransactionProgramer;
import once.curso.proyectobanco.repositories.CurrentAccountCRUDRepository;
import once.curso.proyectobanco.repositories.DescriptionCRUDRepository;
import once.curso.proyectobanco.repositories.TimingTypeCRUDRepository;
import once.curso.proyectobanco.repositories.TransactionCRUDRepository;
import once.curso.proyectobanco.repositories.TransactionProgramerCRUDRepository;

@Data
@Service
public class TransactionProgramerService {

	@Autowired
	private CurrentAccountCRUDRepository currentAccountCRUDRepository;
	
	@Autowired
	private DescriptionCRUDRepository DescriptionCRUDRepository;
	
	@Autowired
	private TransactionProgramerCRUDRepository transactionProgramerCRUDRepository;
	
	@Autowired
	private TimingTypeCRUDRepository timingTypeCRUDRepository;
	
	public <S extends TransactionProgramer> S save(S entity) {
		return getTransactionProgramerCRUDRepository().save(entity);
	}

	public <S extends TransactionProgramer> Iterable<S> saveAll(Iterable<S> entities) {
		return getTransactionProgramerCRUDRepository().saveAll(entities);
	}

	public Optional<TransactionProgramer> findById(Integer id) {
		return getTransactionProgramerCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getTransactionProgramerCRUDRepository().existsById(id);
	}

	public Iterable<TransactionProgramer> findAll() {
		return getTransactionProgramerCRUDRepository().findAll();
	}

	public Iterable<TransactionProgramer> findAllById(Iterable<Integer> ids) {
		return getTransactionProgramerCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getTransactionProgramerCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getTransactionProgramerCRUDRepository().deleteById(id);
	}

	public void delete(TransactionProgramer entity) {
		getTransactionProgramerCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getTransactionProgramerCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends TransactionProgramer> entities) {
		getTransactionProgramerCRUDRepository().deleteAll();
	}

	public void deleteAll() {
		getTransactionProgramerCRUDRepository().deleteAll();
	}

	public Iterable<TransactionProgramer> findAll(Sort sort) {
		return getTransactionProgramerCRUDRepository().findAll(sort);
	}

	public Page<TransactionProgramer> findAll(Pageable pageable) {
		return getTransactionProgramerCRUDRepository().findAll(pageable);
	}

	public List<TransactionProgramer> getTransactionsByCurrentAccount(int id) {
		
		return getTransactionProgramerCRUDRepository(). getTransactionsByCurrentAccount(int id);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}