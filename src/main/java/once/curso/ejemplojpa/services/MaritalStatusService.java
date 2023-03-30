package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.MaritalEstatus;
import once.curso.ejemplojpa.repositories.MaritalStatusRepository;

@Data
@Service
public class MaritalStatusService {

	@Autowired
	private MaritalStatusRepository maritalStatusRepository;

	public void estadoCivil() {

		Iterable<MaritalEstatus> estadoCivil = getMaritalStatusRepository().findAll();
		for (MaritalEstatus maritalEstatus : estadoCivil) {
			System.out.println(maritalEstatus.getDescription());

		}

	}

	public <S extends MaritalEstatus> S save(S entity) {
		return getMaritalStatusRepository().save(entity);
	}

	public <S extends MaritalEstatus> Iterable<S> saveAll(Iterable<S> entities) {
		return getMaritalStatusRepository().saveAll(entities);
	}

	public Optional<MaritalEstatus> findById(Integer id) {
		return getMaritalStatusRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getMaritalStatusRepository().existsById(id);
	}

	public Iterable<MaritalEstatus> findAll() {
		return getMaritalStatusRepository().findAll();
	}

	public Iterable<MaritalEstatus> findAllById(Iterable<Integer> ids) {
		return getMaritalStatusRepository().findAllById(ids);
	}

	public long count() {
		return getMaritalStatusRepository().count();
	}

	public void deleteById(Integer id) {
		getMaritalStatusRepository().deleteById(id);
	}

	public void delete(MaritalEstatus entity) {
		getMaritalStatusRepository().deleteAll();
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getMaritalStatusRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends MaritalEstatus> entities) {
		getMaritalStatusRepository().deleteAll();
	}

	public void deleteAll() {
		getMaritalStatusRepository().deleteAll();
	}
}
