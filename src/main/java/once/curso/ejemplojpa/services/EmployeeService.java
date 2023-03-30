package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Employee;
import once.curso.ejemplojpa.repositories.EmployeeRepository;

@Service
@Data
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void dameEmpleados() {
		Iterable<Employee> empleados= getEmployeeRepository().findAll();
		for (Employee employee : empleados) {
			System.out.println(employee.getName());
			System.out.println(employee.getNif());
			System.out.println(employee.getPhone());
			System.out.println(employee.getBirthDate());
			System.out.println(employee.getDateHight());
			System.out.println(employee.getLowDate());
			System.out.println(employee.getPersonalInformation());
			System.out.println(employee.getLaboralInformation());
			System.out.println(employee.getCompany());
		}
	}
	public <S extends Employee> S save(S entity) {
		return getEmployeeRepository().save(entity);
	}

	public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
		return getEmployeeRepository().saveAll(entities);
	}

	public Optional<Employee> findById(Integer id) {
		return getEmployeeRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getEmployeeRepository().existsById(id);
	}

	public Iterable<Employee> findAll() {
		return getEmployeeRepository().findAll();
	}

	public Iterable<Employee> findAllById(Iterable<Integer> ids) {
		return getEmployeeRepository().findAllById(ids);
	}

	public long count() {
		return getEmployeeRepository().count();
	}

	public void deleteById(Integer id) {
		getEmployeeRepository().deleteById(id);
	}

	public void delete(Employee entity) {
		getEmployeeRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getEmployeeRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Employee> entities) {
		getEmployeeRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getEmployeeRepository().deleteAll();
	}

}
