package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.repositories.ChildCRUDRepository;

@Service
@Data
public class ChildService {

	@Autowired
	private ChildCRUDRepository childrenCRUDRepository;

	public Iterable<Child> getDatosLaborales() {

		return getChildrenCRUDRepository().findAll();
	}

	public <S extends Child> S save(S entity) {

		return getChildrenCRUDRepository().save(entity);
	}

	public <S extends Child> Iterable<S> saveAll(Iterable<S> entities) {

		return getChildrenCRUDRepository().saveAll(entities);
	}

	public Optional<Child> findById(Integer id) {

		return getChildrenCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getChildrenCRUDRepository().existsById(id);
	}

	public Iterable<Child> findAll() {

		return getChildrenCRUDRepository().findAll();
	}

	public Iterable<Child> findAllById(Iterable<Integer> ids) {

		return getChildrenCRUDRepository().findAllById(ids);
	}

	public long count() {

		return getChildrenCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		
		getChildrenCRUDRepository().deleteById(id);
	}

	public void delete(Child entity) {
		getChildrenCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getChildrenCRUDRepository().deleteAll();
	}

	public void deleteAll(Iterable<? extends Child> entities) {
		getChildrenCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getChildrenCRUDRepository().deleteAll();
	}

}
