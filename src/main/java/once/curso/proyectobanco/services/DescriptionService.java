package once.curso.proyectobanco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.Description;
import once.curso.proyectobanco.repositories.DescriptionCRUDRepository;

@Data
@Service
public class DescriptionService {
	
	@Autowired
	private DescriptionCRUDRepository DescriptionCRUDRepository;
	
	public Iterable<Description> dameDescripcion() {
		return getDescriptionCRUDRepository().findAll();
		
		}
			
	public <S extends Description> S save(S entity) {
		return getDescriptionCRUDRepository().save(entity);
	}

	public <S extends Description> Iterable<S> saveAll(Iterable<S> entities) {
		return getDescriptionCRUDRepository().saveAll(entities);
	}

	public Optional<Description> findById(Integer id) {
		return getDescriptionCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getDescriptionCRUDRepository().existsById(id);
	}

	public Iterable<Description> findAll() {
		return getDescriptionCRUDRepository().findAll();
	}

	public Iterable<Description> findAllById(Iterable<Integer> ids) {
		return getDescriptionCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getDescriptionCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getDescriptionCRUDRepository().deleteById(id);
	}

	public void delete(Description entity) {
		getDescriptionCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getDescriptionCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Description> entities) {
		getDescriptionCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getDescriptionCRUDRepository().deleteAll();
	}
}
