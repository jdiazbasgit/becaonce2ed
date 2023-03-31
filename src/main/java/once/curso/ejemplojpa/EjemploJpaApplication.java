package once.curso.ejemplojpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;
import once.curso.ejemplojpa.entityes.LaboralInformation;
import once.curso.ejemplojpa.services.ChargeService;
import once.curso.ejemplojpa.services.LaboralInformationService;

@SpringBootApplication
@Data
public class EjemploJpaApplication implements CommandLineRunner {

	@Autowired
	private ChargeService chargeService;

	@Autowired
	private LaboralInformationService laboralInformationService;

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

	}

}
