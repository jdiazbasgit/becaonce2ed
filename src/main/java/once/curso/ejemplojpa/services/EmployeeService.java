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
	public EmployeeRepository employeeRepository;
	
	public void dameEmpleados() {
		Iterable<EmployeeRepository> empleados= getEmployeeRepository().findAll();
		for (EmployeeRepository employee : empleados) {
			/*System.out.println(employee.());
			System.out.println(employee.getNif());
			System.out.println(employee.getPhone());
			System.out.println(employee.getBirthDate());
			System.out.println(employee.getDateHight());
			System.out.println(employee.getLowDate());
			System.out.println(employee.getPersonalInformation());
			System.out.println(employee.getLaboralInformation());
			System.out.println(employee.getCompany());*/
		}
	}

}
