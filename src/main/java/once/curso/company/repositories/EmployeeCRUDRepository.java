package once.curso.company.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import once.curso.company.entities.Employee;
@Repository
public interface EmployeeCRUDRepository extends CrudRepository<Employee, Integer> {

	
}
