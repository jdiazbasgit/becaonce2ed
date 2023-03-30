package once.curso.ejemplojpa.repositories;

import org.springframework.data.repository.CrudRepository;

import once.curso.ejemplojpa.entityes.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
