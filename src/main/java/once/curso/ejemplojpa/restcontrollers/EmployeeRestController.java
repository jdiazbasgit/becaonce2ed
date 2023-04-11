package once.curso.ejemplojpa.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Employee;
import once.curso.ejemplojpa.repositories.EmployeeRepository;
import once.curso.ejemplojpa.services.EmployeeService;

@RestController
@Data
@RequestMapping("/once")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public Iterable<Employee> todosEmpleados() {
		return getEmployeeService().findAll();
	}

	@GetMapping(value = "/employees/guys/{cantidad}")
	public List<Employee> getEmpleadosbyGuys(@PathVariable int cantidad) {
		return getEmployeeService().getEmpleadosbyGuys(cantidad);
	}

}
