package once.curso.proyectobancojpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;
import once.curso.proyectobancojpa.services.AwardFineConfigurationService;
import once.curso.proyectobancojpa.services.AwardFineService;
import once.curso.proyectobancojpa.services.AwardFineTypeService;

@SpringBootApplication
@Data
public class ProyectosApplication implements CommandLineRunner{
	
	@Autowired 
	private AwardFineService awardFineService;
	
	@Autowired
	private AwardFineConfigurationService awardFineConfigurationService;
	
	@Autowired
	private AwardFineTypeService awardFineTypeService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		getAwardFineService().dameTipoPremiosMultas();
		getAwardFineConfigurationService().damePremiosMultasConfiguraciones();
		getAwardFineTypeService().dameAwardFineType();
	}
}
