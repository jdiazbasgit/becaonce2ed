package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entities.Child;
import once.curso.ejemplojpa.repositories.ChildCRUDRepository;

@Service
@Data
public class ChildService {

	@Autowired
	private ChildCRUDRepository childCRUDRepository;

	public long count() {
		return childCRUDRepository.count();
	}

	
	public void delete(Child entity) {

	}

	
	public void deleteAll() {

	}

	
	public void deleteAll(Iterable<? extends Child> entities) {

	}

	
	public void deleteAllById(Iterable<? extends Integer> ids) {

	}

	
	public void deleteById(Integer id) {

	}

	
	public boolean existsById(Integer id) {
		return false;
	}

	
	public Iterable<Child> findAll() {
		return childCRUDRepository.findAll();
	}

	
	public Iterable<Child> findAllById(Iterable<Integer> ids) {
		return childCRUDRepository.findAllById(ids);
	}

	
	public Optional<Child> findById(Integer id) {
		return childCRUDRepository.findById(id);
	}

	
	public <S extends Child> S save(S entity) {
		return childCRUDRepository.save(entity);
	}
	//la declación genérica <S extends Child> se utiliza para restringir el tipo de argumentos que pueden ser pasados al método
	//y para especificar el tipo de valor de retorno del método. Un iterable de objetos S. El equivalente super podría ser:
/*
	public Iterable<Child> save(Child entity) {
		return childCRUDRepository.save(entity);
	}
*/

	public <S extends Child> Iterable<S> saveAll(Iterable<S> entities) {
		return childCRUDRepository.saveAll(entities);
	}

}
