package once.curso.company.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.company.entities.Employee;
import once.curso.company.repositories.EmployeeCRUDRepository;

@Service
@Data
public class EmployeeService {

	@Autowired
	private EmployeeCRUDRepository employeeCRUDRepository;

	public <S extends Employee> S save(S entity) {
		return getEmployeeCRUDRepository().save(entity);
	}

	public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
		return getEmployeeCRUDRepository().saveAll(entities);
	}

	public Optional<Employee> findById(Integer id) {
		return getEmployeeCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getEmployeeCRUDRepository().existsById(id);
	}

	public Iterable<Employee> findAll() {
		return getEmployeeCRUDRepository().findAll();
	}

	public Iterable<Employee> findAllById(Iterable<Integer> ids) {
		return getEmployeeCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getEmployeeCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getEmployeeCRUDRepository().deleteById(id);
	}

	public void delete(Employee entity) {
		getEmployeeCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getEmployeeCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Employee> entities) {
		getEmployeeCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getEmployeeCRUDRepository().deleteAll();
	}
}
