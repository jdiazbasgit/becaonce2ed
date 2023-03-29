package once.curso.ejemplojpa.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entities.Employee;

@Repository
public interface EmployeeCRUDRepository extends CrudRepository<Employee, Integer> {	
}
