package once.curso.ejemplojpa.services;

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
			System.out.println(employee.getLowCalendar());
			System.out.println(employee.getDatosPersonales());
			System.out.println(employee.getDatosLaborales());
			System.out.println(employee.getCompañias());
		}
	}

}
