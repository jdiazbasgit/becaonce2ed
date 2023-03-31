package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.LaboralInformation;
import once.curso.ejemplojpa.repositories.LaboralInformationCRUDRepository;

@Service
@Data
public class LaboralInformationService {

	@Autowired
	private LaboralInformationCRUDRepository laboralInformationCRUDRepository;

	public Iterable<LaboralInformation> getDatosLaborales() {
		return getLaboralInformationCRUDRepository().findAll();

	}
	
	public <S extends LaboralInformation> S save(S entity) {
		return getLaboralInformationCRUDRepository().save(entity);
	}

	public <S extends LaboralInformation> Iterable<S> saveAll(Iterable<S> entities) {
		return getLaboralInformationCRUDRepository().saveAll(entities);
	}

	public Optional<LaboralInformation> findById(Integer id) {
		return getLaboralInformationCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getLaboralInformationCRUDRepository().existsById(id);
	}

	public Iterable<LaboralInformation> findAll() {
		return getLaboralInformationCRUDRepository().findAll();
	}

	public Iterable<LaboralInformation> findAllById(Iterable<Integer> ids) {
		return getLaboralInformationCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getLaboralInformationCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getLaboralInformationCRUDRepository().deleteById(id);
	}

	public void delete(LaboralInformation entity) {
		getLaboralInformationCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getLaboralInformationCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends LaboralInformation> entities) {
		getLaboralInformationCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getLaboralInformationCRUDRepository().deleteAll();
	}
}
