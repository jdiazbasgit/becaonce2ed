package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.repositories.ChildRepository;

@Service
@Data
public class ChildService {

	@Autowired
	private ChildRepository childRepository;
	
	public void dameHijos(){
		Iterable<Child> hijos= getChildRepository().findAll();
		for (Child children : hijos) {
			System.out.println(children.getGirl());
			System.out.println(children.getGuy());
		}
	}
	
	public Child save(Child child) {
		return getChildRepository().save(child);
	}

	public <S extends Child> Iterable<S> saveAll(Iterable<S> entities) {
		return getChildRepository().saveAll(entities);
	}

	public Optional<Child> findById(Integer id) {
		return getChildRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getChildRepository().existsById(id);
	}

	public Iterable<Child> findAll() {
		return getChildRepository().findAll();
	}

	public Iterable<Child> findAllById(Iterable<Integer> ids) {
		return getChildRepository().findAllById(ids);
	}

	public long count() {
		return getChildRepository().count();
	}

	public void deleteById(Integer id) {
		getChildRepository().deleteById(id);
	}

	public void delete(Child entity) {
		getChildRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getChildRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Child> entities) {
		getChildRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getChildRepository().deleteAll();
	}
	
}
