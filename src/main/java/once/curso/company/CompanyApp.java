package once.curso.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;
import once.curso.company.services.ChargeService;
import once.curso.company.entities.Charge;
import once.curso.company.services.ChildService;
import once.curso.company.entities.Child;
import once.curso.company.services.CompanyService;
import once.curso.company.entities.Company;
import once.curso.company.services.EmployeeService;
import once.curso.company.entities.Employee;
import once.curso.company.services.LaboralInformationService;
import once.curso.company.entities.LaboralInformation;
import once.curso.company.services.MaritalStatusService;
import once.curso.company.entities.MaritalStatus;
import once.curso.company.services.PersonalInformationService;
import once.curso.company.entities.PersonalInformation;

@SpringBootApplication
@Data
public class CompanyApp implements CommandLineRunner {
	@Autowired
	private ChargeService chargeService;
	@Autowired
	private ChildService childService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private LaboralInformationService laboralInformationService;
	@Autowired
	private MaritalStatusService maritalStatusService;
	@Autowired
	private PersonalInformationService personalInformationService;

	public static void main(String[] args) {
		SpringApplication.run(CompanyApp.class, args);
	}

	public void run(String... args) throws Exception {

//--------------Código prescindible, imprimirá el contenido de las tablas en consola---------------

		Iterable<Charge> iterCharge = getChargeService().findAll();
		for (Charge charge : iterCharge) {
			System.out.println(charge.getId());
			System.out.println(charge.getDescription());
		}

		Iterable<Child> iterChild = getChildService().findAll();
		for (Child child : iterChild) {
			System.out.println(child.getId());
			System.out.println(child.getGuys());
			System.out.println(child.getGirls());
		}

		Iterable<Company> iterCompany = getCompanyService().findAll();
		for (Company company : iterCompany) {
			System.out.println(company.getId());
			System.out.println(company.getCif());
			System.out.println(company.getDescription());
		}

		Iterable<Employee> iterEmployee = getEmployeeService().findAll();
		for (Employee employee : iterEmployee) {
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getNif());
			System.out.println(employee.getPhone());
			System.out.println(employee.getBirthDate());
			System.out.println(employee.getDateHight());
			System.out.println(employee.getLowDate());
			System.out.println(employee.getPersonalInformation());
			System.out.println(employee.getLaboralInformation());
			System.out.println(employee.getCompany());
		}

		Iterable<LaboralInformation> iterLaboralInformation = getLaboralInformationService().findAll();
		for (LaboralInformation laboralInformation : iterLaboralInformation) {
			System.out.println(laboralInformation.getId());
			System.out.println(laboralInformation.getSalary());
			System.out.println(laboralInformation.getCharge());
		}

		Iterable<MaritalStatus> iterMaritalStatus = getMaritalStatusService().findAll();
		for (MaritalStatus maritalStatus : iterMaritalStatus) {
			System.out.println(maritalStatus.getId());
			System.out.println(maritalStatus.getDescription());
		}

		Iterable<PersonalInformation> iterPersonalInformation = getPersonalInformationService().findAll();
		for (PersonalInformation personalInformation : iterPersonalInformation) {
			System.out.println(personalInformation.getId());
			System.out.println(personalInformation.getChild());
			System.out.println(personalInformation.getMaritalStatus());
		}
//--------------                                                                    ---------------

	}
}
