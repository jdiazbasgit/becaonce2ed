package once.curso.ejemplojpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Charge;
import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.entityes.LaboralInformation;
import once.curso.ejemplojpa.entityes.MaritalStatus;
import once.curso.ejemplojpa.entityes.PersonalInformation;
import once.curso.ejemplojpa.services.ChargeService;
import once.curso.ejemplojpa.services.ChildService;
import once.curso.ejemplojpa.services.CompanyService;
import once.curso.ejemplojpa.services.EmployeeService;
import once.curso.ejemplojpa.services.LaboralInformationService;
import once.curso.ejemplojpa.services.MaritalStatusService;
import once.curso.ejemplojpa.services.PersonalInformationService;

@SpringBootApplication
@Data
public class EjemploJpaApplication implements CommandLineRunner {

	@Autowired
	private ChargeService chargeService;

	@Autowired
	private LaboralInformationService laboralInformationService;

	@Autowired
	private ChildService childrenService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private MaritalStatusService maritalStatusService;

	@Autowired
	private PersonalInformationService personalInformationService;

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(EjemploJpaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		getChargeService().dameCargos();

		String[] cargosFiltrados = getChargeService().dameCargosQueEmpiecenPor("D%");
		for (int i = 0; i < cargosFiltrados.length; i++) {
			System.err.println(cargosFiltrados[i]);
		}

		Iterable<LaboralInformation> datos = getLaboralInformationService().getDatosLaborales();

		for (LaboralInformation laboralInformation : datos) {
			System.out.println(laboralInformation.getSalary());// +" -
																// "+laboralInformation.getCharge().getDescription());
			System.out.println(laboralInformation.getCharge().getDescription());
		}
		getChildrenService().dameHijos();
		getCompanyService().dameEmpresas();
		getMaritalStatusService().dameEstadoCivil();
		getPersonalInformationService().dameDatosPersonales();
		getEmployeeService().dameEmpleados();
	}

}
