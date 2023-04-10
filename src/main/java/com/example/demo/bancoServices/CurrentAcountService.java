package com.example.demo.bancoServices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bancoEntityes.CurrentAcount;
import com.example.demo.bancoRepositories.CurrentAcountRepository;

import lombok.Data;

@Data
@Service

public class CurrentAcountService {

	@Autowired
	private CurrentAcountRepository currentAcountRepository;

	public void dameDeposito() {
		Iterable<CurrentAcount> depositos = getCurrentAcountRepository().findAll();
		for (CurrentAcount currentAcount : depositos) {
			System.out.println(currentAcount.getNumber());
			System.out.println(currentAcount.getCreationDate());
			System.out.println(currentAcount.getFee());
			System.out.println(currentAcount.getTypeAccount());
			System.out.println(currentAcount.getUser());
		}
	}

	public long count() {
		return getCurrentAcountRepository().count();
	}

	public void delete(CurrentAcount entity) {
		getCurrentAcountRepository().delete(entity);
	}

	public void deleteAll() {
		getCurrentAcountRepository().deleteAll();
	}

	public void deleteAll(Iterable<? extends CurrentAcount> entities) {
		getCurrentAcountRepository().deleteAll(entities);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getCurrentAcountRepository().deleteAllById(ids);
	}

	public void deleteById(Integer id) {
		getCurrentAcountRepository().deleteById(id);
	}

	public boolean existsById(Integer id) {
		return getCurrentAcountRepository().existsById(id);
	}

	public Iterable<CurrentAcount> findAll() {
		return getCurrentAcountRepository().findAll();
	}

	public Iterable<CurrentAcount> findAllById(Iterable<Integer> ids) {
		return getCurrentAcountRepository().findAllById(ids);
	}

	public Optional<CurrentAcount> findById(Integer id) {
		return getCurrentAcountRepository().findById(id);
	}

	public <S extends CurrentAcount> S save(S entity) {
		return getCurrentAcountRepository().save(entity);
	}

	public <S extends CurrentAcount> Iterable<S> saveAll(Iterable<S> entities) {
		return getCurrentAcountRepository().saveAll(entities);
	}

}
