package once.curso.ejemplojpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	@Query("from Employee as e where e.personalInformation.children.guy > :cantidad")
	public List<Employee> getEmpleadosbyGuys(int cantidad);
	
	
	

}
