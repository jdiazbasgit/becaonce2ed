package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.repositories.HijosRepository2;

@Service
@Data
public class ChildServices {
	@Autowired
	private HijosRepository2 hijosRepository2;
	
	public void dameHijos() {
		Iterable<Child> hijo = getHijosRepository2().findAll();
		for (Child hijos : hijo) {
			System.out.println(hijos.getGirls());
			System.out.println(hijos.getGuys());
			
		}
		
		
		
	}
	

	
	public <S extends Child> S save(S entity) {
		
		return getHijosRepository2().save(entity);
	}


	public <S extends Child> Iterable<S> saveAll(Iterable<S> entities) {
		
		return getHijosRepository2().saveAll(entities);
	}


	public Optional<Child> findById(Integer id) {
		
		return getHijosRepository2().findById(id);
	}

	
	public boolean existsById(Integer id) {
		
		return getHijosRepository2().existsById(id);
	}

	
	public Iterable<Child> findAll() {
		
		return getHijosRepository2().findAll();
	}


	public Iterable<Child> findAllById(Iterable<Integer> ids) {
		return getHijosRepository2().findAllById(ids);
	}

	
	public long count() {
		return getHijosRepository2().count();
	}

	
	public void deleteById(Integer id) {
	  getHijosRepository2().deleteById(id);
		
	}

	
	public void delete(Child entity) {
		getHijosRepository2().delete(entity);
		
	}

	
	public void deleteAllById(Iterable<? extends Integer> ids) {
		getHijosRepository2().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Child> entities) {
			getHijosRepository2().deleteAll(entities);
		
	}

	
	public void deleteAll() {
		getHijosRepository2().deleteAll();
		
	}
	
	

}
