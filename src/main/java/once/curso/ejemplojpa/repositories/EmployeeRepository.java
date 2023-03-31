package once.curso.ejemplojpa.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import once.curso.ejemplojpa.entityes.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	
}
