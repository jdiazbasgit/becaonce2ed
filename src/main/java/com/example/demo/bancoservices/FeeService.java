package com.example.demo.bancoservices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bancoentityes.Fee;
import com.example.demo.bancorepositories.FeeRepository;

import lombok.Data;

@Data
@Service
public class FeeService {
	
	@Autowired
	private FeeRepository feeRepository;
	
	public void dameTarifa() {
		Iterable<Fee> tarifa= getFeeRepository().findAll();
		for (Fee fee : tarifa) {
			System.out.println(fee.getCurrent());
			
		}
	}
	public long count() {
		return getFeeRepository().count();
	}

	public void delete(Fee entity) {
	getFeeRepository().delete(entity);	
	}

	public void deleteAll() {
		getFeeRepository().deleteAll();
	}

	public void deleteAll(Iterable<? extends Fee> entities) {
		getFeeRepository().deleteAll(entities);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getFeeRepository().deleteAllById(ids);
	}

	public void deleteById(Integer id) {
		getFeeRepository().deleteById(id);
	}

	public boolean existsById(Integer id) {
		return getFeeRepository().existsById(id);
	}

	public Iterable<Fee> findAll() {
		return getFeeRepository().findAll();
	}

	public Iterable<Fee> findAllById(Iterable<Integer> ids) {
		return getFeeRepository().findAllById(ids);
	}

	public Optional<Fee> findById(Integer id) {
		return getFeeRepository().findById(id);
	}

	public <S extends Fee> S save(S entity) {
		return getFeeRepository().save(entity);
	}

	public <S extends Fee> Iterable<S> saveAll(Iterable<S> entities) {
		return getFeeRepository().saveAll(entities);
	}

}
