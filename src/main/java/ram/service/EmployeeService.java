package ram.service;

public class EmployeeService {
	public String addEmployee(String saludo) {
		System.out.println("Add Employee");
		System.out.println(saludo);
		return "Hola";
	}
	
	public void modifyEmployee() {
		System.out.println("Modify Employee");
	}
	
	public void deleteEmployee() {
		System.out.println("Delete Employee");
	}
}
