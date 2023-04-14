package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.IdentificationType;
import once.curso.proyectobanco.repositories.IdentificationTypeCRUDRepository;

@Service
@Data
public class IdentificationTypeService {

	@Autowired
	private IdentificationTypeCRUDRepository identificationTypeCRUDRepository;

	public <S extends IdentificationType> S save(S entity) {
		return getIdentificationTypeCRUDRepository().save(entity);
	}

	public <S extends IdentificationType> Iterable<S> saveAll(Iterable<S> entities) {
		return getIdentificationTypeCRUDRepository().saveAll(entities);
	}

	public Optional<IdentificationType> findById(Integer id) {
		return getIdentificationTypeCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getIdentificationTypeCRUDRepository().existsById(id);
	}

	public Iterable<IdentificationType> findAll() {
		return getIdentificationTypeCRUDRepository().findAll();
	}

	public Iterable<IdentificationType> findAllById(Iterable<Integer> ids) {
		return getIdentificationTypeCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getIdentificationTypeCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getIdentificationTypeCRUDRepository().deleteById(id);
	}

	public void delete(IdentificationType entity) {
		getIdentificationTypeCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getIdentificationTypeCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends IdentificationType> entities) {
		getIdentificationTypeCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getIdentificationTypeCRUDRepository().deleteAll();
	}
}
