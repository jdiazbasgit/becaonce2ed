package once.curso.ejemplojpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class EnployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void dameEmployees() {
		
		Iterable<Employee> employees = getEmployeesRepository().findAll;
		for (Employee employee : employees) {
			System.out.println(employee.getName);
			
		}
	}

}
