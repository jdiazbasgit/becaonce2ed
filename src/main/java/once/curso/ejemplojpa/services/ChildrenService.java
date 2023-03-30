package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Children;
import once.curso.ejemplojpa.repositories.ChildrenCRUDRepository;

@Service
@Data
public class ChildrenService {

	@Autowired
	private ChildrenCRUDRepository childrenCRUDRepository;

	public Iterable<Children> getDatosLaborales() {

		return getChildrenCRUDRepository().findAll();
	}

	public <S extends Children> S save(S entity) {

		return getChildrenCRUDRepository().save(entity);
	}

	public <S extends Children> Iterable<S> saveAll(Iterable<S> entities) {

		return getChildrenCRUDRepository().saveAll(entities);
	}

	public Optional<Children> findById(Integer id) {

		return getChildrenCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getChildrenCRUDRepository().existsById(id);
	}

	public Iterable<Children> findAll() {

		return getChildrenCRUDRepository().findAll();
	}

	public Iterable<Children> findAllById(Iterable<Integer> ids) {

		return getChildrenCRUDRepository().findAllById(ids);
	}

	public long count() {

		return getChildrenCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		
		getChildrenCRUDRepository().deleteById(id);
	}

	public void delete(Children entity) {
		getChildrenCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getChildrenCRUDRepository().deleteAll();
	}

	public void deleteAll(Iterable<? extends Children> entities) {
		getChildrenCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getChildrenCRUDRepository().deleteAll();
	}

}
