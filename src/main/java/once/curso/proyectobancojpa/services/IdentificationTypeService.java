package once.curso.proyectobancojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobancojpa.entities.IdentificationType;
import once.curso.proyectobancojpa.repositories.IdentificationTypeRepository;

@Service
@Data
public class IdentificationTypeService {

	@Autowired
	private IdentificationTypeRepository identificationTypeRepository;

	public void dameTiposDeIdentificacion() {

		Iterable<IdentificationType> identificationTypes = getIdentificationTypeRepository().findAll();
		for (IdentificationType identificationType : identificationTypes) {
			System.out.println(identificationType.getDescription());
		}
	}

	public <S extends IdentificationType> S save(S entity) {

		return getIdentificationTypeRepository().save(entity);
	}

	public <S extends IdentificationType> Iterable<S> saveAll(Iterable<S> entities) {

		return getIdentificationTypeRepository().saveAll(entities);
	}

	public Optional<IdentificationType> findById(Integer id) {

		return getIdentificationTypeRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getIdentificationTypeRepository().existsById(id);
	}

	public Iterable<IdentificationType> findAll() {

		return getIdentificationTypeRepository().findAll();
	}

	public Iterable<IdentificationType> findAllById(Iterable<Integer> ids) {

		return getIdentificationTypeRepository().findAllById(ids);
	}

	public long count() {

		return getIdentificationTypeRepository().count();
	}

	public void deleteById(Integer id) {
		getIdentificationTypeRepository().deleteById(id);

	}

	public void delete(IdentificationType entity) {
		getIdentificationTypeRepository().delete(entity);

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getIdentificationTypeRepository().deleteAllById(ids);

	}

	public void deleteAll(Iterable<? extends IdentificationType> entities) {
		getIdentificationTypeRepository().deleteAll(entities);

	}

	public void deleteAll() {
		getIdentificationTypeRepository().deleteAll();

	}
}
