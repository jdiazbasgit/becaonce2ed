package once.curso.ejemplojpa.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.repositories.ChildrenRepository;

@Service
@Data
public class ChildService {

	@Autowired
	private ChildrenRepository childrenRepository;
	
	public void dameHijos() {
		Iterable<Child> hijos= getChildrenRepository().findAll();
		for (Child children : hijos) {
			System.out.println(children.getGuys());
			System.out.println(children.getGirl());
			
		}
	}
	public <S extends Child> S save(S entity) {
		return getChildrenRepository().save(entity);
	}

	public <S extends Child> Iterable<S> saveAll(Iterable<S> entities) {
		return getChildrenRepository().saveAll(entities);
	}

	public Iterable<Child> findById(Integer id) {
		return getChildrenRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getChildrenRepository().existsById(id);
	}

	public Iterable<Child> findAll() {
		return getChildrenRepository().findAll();
	}

	public Iterable<Child> findAllById(Iterable<Integer> ids) {
		return getChildrenRepository().findAllById(ids);
	}

	public long count() {
		return getChildrenRepository().count();
	}

	public void deleteById(Integer id) {
		getChildrenRepository().deleteById(id);
	}

	public void delete(Child entity) {
		getChildrenRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getChildrenRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Child> entities) {
		getChildrenRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getChildrenRepository().deleteAll();
	}
}
