package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.repositories.EmployeeCRUDRepository;

@Service
@Data
public class EmployeeService {

	@Autowired
	private EmployeeCRUDRepository employeeCRUDRepository;

	public <S extends EmployeeCRUDRepository> S save(S entity) {

		return getEmployeeCRUDRepository().save(entity);
	}

	public <S extends EmployeeCRUDRepository> Iterable<S> saveAll(Iterable<S> entities) {

		return getEmployeeCRUDRepository().saveAll(entities);
	}

	public Optional<EmployeeCRUDRepository> findById(Integer id) {

		return getEmployeeCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getEmployeeCRUDRepository().existsById(id);
	}

	public Iterable<EmployeeCRUDRepository> findAll() {

		return getEmployeeCRUDRepository().findAll();
	}

	public Iterable<EmployeeCRUDRepository> findAllById(Iterable<Integer> ids) {

		return getEmployeeCRUDRepository().findAllById(ids);
	}

	public long count() {

		return getEmployeeCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getEmployeeCRUDRepository().deleteById(id);
	}

	public void delete(EmployeeCRUDRepository entity) {
		getEmployeeCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getEmployeeCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends EmployeeCRUDRepository> entities) {
		getEmployeeCRUDRepository().deleteAll();
	}

	public void deleteAll() {
		getEmployeeCRUDRepository().deleteAll();
	}
}
