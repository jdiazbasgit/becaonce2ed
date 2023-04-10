package com.example.demo.bancoservices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bancoentityes.AwardFineType;
import com.example.demo.bancorepositories.AwardFineTypeRepository;

import lombok.Data;

@Service
@Data

public class AwardFineTypeService {

	@Autowired
	private AwardFineTypeRepository awardFineTypeRepository;

	public void dameTipoMulta() {
		Iterable<AwardFineType> tipoMulta = getAwardFineTypeRepository().findAll();
		for (AwardFineType awardFineType : tipoMulta) {
			System.out.println(awardFineType.getDescription());

		}
	}

	public long count() {
		return getAwardFineTypeRepository().count();
	}

	public void delete(AwardFineType entity) {
		getAwardFineTypeRepository().delete(entity);
	}

	public void deleteAll() {
		getAwardFineTypeRepository().deleteAll();
	}

	public void deleteAll(Iterable<? extends AwardFineType> entities) {
		getAwardFineTypeRepository().deleteAll(entities);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getAwardFineTypeRepository().deleteAllById(ids);
		;
	}

	public void deleteById(Integer id) {
		getAwardFineTypeRepository().deleteById(id);
	}

	public boolean existsById(Integer id) {
		return getAwardFineTypeRepository().existsById(id);
	}

	public Iterable<AwardFineType> findAll() {
		return getAwardFineTypeRepository().findAll();
	}

	public Iterable<AwardFineType> findAllById(Iterable<Integer> ids) {
		return getAwardFineTypeRepository().findAllById(ids);
	}

	public Optional<AwardFineType> findById(Integer id) {
		return getAwardFineTypeRepository().findById(id);
	}

	public <S extends AwardFineType> S save(S entity) {
		return getAwardFineTypeRepository().save(entity);
	}

	public <S extends AwardFineType> Iterable<S> saveAll(Iterable<S> entities) {
		return getAwardFineTypeRepository().saveAll(entities);
	}
}
