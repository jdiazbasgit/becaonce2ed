package com.example.demo.bancoServices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bancoEntityes.TransactionAwardFine;
import com.example.demo.bancoRepositories.TransactionAwardFineRepository;

import lombok.Data;

@Data
@Service
public class TransactionAwardFineService {

	@Autowired
	private TransactionAwardFineRepository awardFineRepository;

	public void dameMultaPorTransaccion() {
		Iterable<TransactionAwardFine> multaTransaccion = getAwardFineRepository().findAll();
		for (TransactionAwardFine transactionAwardFine : multaTransaccion) {
			System.out.println(transactionAwardFine.getTransaction());
			System.out.println(transactionAwardFine.getAwardFineType());

		}
	}

	public <S extends TransactionAwardFine> S save(S entity) {
		return getAwardFineRepository().save(entity);
	}

	public <S extends TransactionAwardFine> Iterable<S> saveAll(Iterable<S> entities) {
		return getAwardFineRepository().saveAll(entities);
	}

	public Optional<TransactionAwardFine> findById(Integer id) {
		return getAwardFineRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getAwardFineRepository().existsById(id);
	}

	public Iterable<TransactionAwardFine> findAll() {
		return getAwardFineRepository().findAll();
	}

	public Iterable<TransactionAwardFine> findAllById(Iterable<Integer> ids) {
		return getAwardFineRepository().findAllById(ids);
	}

	public long count() {
		return getAwardFineRepository().count();
	}

	public void deleteById(Integer id) {
		getAwardFineRepository().deleteById(id);
	}

	public void delete(TransactionAwardFine entity) {
		getAwardFineRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getAwardFineRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends TransactionAwardFine> entities) {
		getAwardFineRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getAwardFineRepository().deleteAll();
	}

}
