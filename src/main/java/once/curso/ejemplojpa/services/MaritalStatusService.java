package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.MaritalStatus;
import once.curso.ejemplojpa.repositories.MaritalStatusCRUDRepository;

@Service
@Data
public class MaritalStatusService {

	@Autowired
	private MaritalStatusCRUDRepository maritalStatusCRUDRepository;

	public <S extends MaritalStatus> S save(S entity) {

		return getMaritalStatusCRUDRepository().save(entity);
	}

	public <S extends MaritalStatus> Iterable<S> saveAll(Iterable<S> entities) {

		return getMaritalStatusCRUDRepository().saveAll(entities);
	}

	public Optional<MaritalStatus> findById(Integer id) {

		return getMaritalStatusCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getMaritalStatusCRUDRepository().existsById(id);
	}

	public Iterable<MaritalStatus> findAll() {

		return getMaritalStatusCRUDRepository().findAll();
	}

	public Iterable<MaritalStatus> findAllById(Iterable<Integer> ids) {

		return getMaritalStatusCRUDRepository().findAllById(ids);
	}

	public long count() {

		return getMaritalStatusCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getMaritalStatusCRUDRepository().deleteById(id);
	}

	public void delete(MaritalStatus entity) {
		getMaritalStatusCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getMaritalStatusCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends MaritalStatus> entities) {
		getMaritalStatusCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getMaritalStatusCRUDRepository().deleteAll();
	}

}
