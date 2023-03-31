package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Employee;
import once.curso.ejemplojpa.repositories.EmployeeCRUDRepository;

@Service
@Data
public class EmployeeService {

	@Autowired
	private EmployeeCRUDRepository employeeCRUDRepository;

	public void dameEmpleados() {
		Iterable<Employee> empleados = getEmployeeCRUDRepository().findAll();
		for (Employee employee : empleados) {
			System.out.println(employee.getName());
			System.out.println(employee.getNif());
			System.out.println(employee.getPhone());
			System.out.println(employee.getBirthDate());
			System.out.println(employee.getDateHight());
			System.out.println(employee.getLowDate());
			System.out.println(employee.getPersonalInformationId());
			System.out.println(employee.getLaboralInforamtionId());
			System.out.println(employee.getCompaniesId());

		}

	}

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

	public void deleteAll(Iterable<? extends EmployeeCRUDRepository> entities) {
		getEmployeeCRUDRepository().deleteAll();
	}

	public void deleteAll() {
		getEmployeeCRUDRepository().deleteAll();
	}
}
