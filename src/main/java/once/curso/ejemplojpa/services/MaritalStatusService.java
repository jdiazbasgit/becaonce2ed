package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.LaboralInformation;
import once.curso.ejemplojpa.entityes.MaritalStatus;
import once.curso.ejemplojpa.repositories.MaritalStatusRepository;

@Service
@Data
public class MaritalStatusService {

	@Autowired
	private MaritalStatusRepository maritalStatusRepository;

	public void dameEstadoCivil() {
		Iterable<MaritalStatus> estadoCivil = getMaritalStatusRepository().findAll();
		for (MaritalStatus maritalStatus : estadoCivil) {
			System.out.println(maritalStatus.getDescription());
		}
	}

	public <S extends MaritalStatus> S save(S entity) {
		return getMaritalStatusRepository().save(entity);
	}

	public <S extends MaritalStatus> Iterable<S> saveAll(Iterable<S> entities) {
		return getMaritalStatusRepository().saveAll(entities);
	}

	public Optional<MaritalStatus> findById(Integer id) {
		return getMaritalStatusRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getMaritalStatusRepository().existsById(id);
	}

	public Iterable<MaritalStatus> findAll() {
		return getMaritalStatusRepository().findAll();
	}

	public Iterable<MaritalStatus> findAllById(Iterable<Integer> ids) {
		return getMaritalStatusRepository().findAllById(ids);
	}

	public long count() {
		return getMaritalStatusRepository().count();
	}

	public void deleteById(Integer id) {

	}

	public void delete(MaritalStatus entity) {

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {

	}

	public void deleteAll(Iterable<? extends MaritalStatus> entities) {

	}

	public void deleteAll() {

	}

}
