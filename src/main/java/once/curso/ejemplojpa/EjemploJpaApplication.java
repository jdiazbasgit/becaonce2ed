package once.curso.ejemplojpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;
import once.curso.ejemplojpa.entityes.LaboralInformation;
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
	private ChildService childrenService;

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
		SpringApplication.run(EjemploJpaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		getChargeService().dameCargos();

		String[] cargosFiltrados = getChargeService().dameCargosQueEmpiecenPor("D%");

		for (int i = 0; i < cargosFiltrados.length; i++) {
			System.err.println(cargosFiltrados[i]);
		}

		Iterable<LaboralInformation> datos = getLaboralInformationService().getDatosLAborales();

		for (LaboralInformation laboralInformation : datos) {
			System.out.println(laboralInformation.getSalary());// +" - "
																// +laboralInformation.getCharge().getDescription());
			System.out.println(laboralInformation.getCharge().getDescription());
		}
		getChildrenService().dameHijos();
		getCompanyService().dameEmpresas();
		getEmployeeService().dameEmpleados();
		getMaritalStatusService().dameEstadoCivil();
		getPersonalInformationService().dameDatosPersonales();

	}

}
