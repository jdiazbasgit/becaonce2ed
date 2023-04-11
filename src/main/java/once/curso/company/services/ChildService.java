package once.curso.company.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.company.entities.Child;
import once.curso.company.repositories.ChildCRUDRepository;

@Service
@Data
public class ChildService {

	@Autowired
	private ChildCRUDRepository childCRUDRepository;
	
	public <S extends Child> S save(S entity) {
		return getChildCRUDRepository().save(entity);
	}

	public <S extends Child> Iterable<S> saveAll(Iterable<S> entities) {
		return getChildCRUDRepository().saveAll(entities);
	}

	public Optional<Child> findById(Integer id) {
		return getChildCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getChildCRUDRepository().existsById(id);
	}

	public Iterable<Child> findAll() {
		return getChildCRUDRepository().findAll();
	}

	public Iterable<Child> findAllById(Iterable<Integer> ids) {
		return getChildCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getChildCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getChildCRUDRepository().deleteById(id);
	}

	public void delete(Child entity) {
		getChildCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getChildCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Child> entities) {
		getChildCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getChildCRUDRepository().deleteAll();
	}
}
