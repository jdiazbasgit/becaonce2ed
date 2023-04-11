package once.curso.ejemplojpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Charge;
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
public class EjemploJpaApplication  {

	
	
	public static void main(String[] args) {
		SpringApplication.run(EjemploJpaApplication.class, args);
		
	}

	
}
