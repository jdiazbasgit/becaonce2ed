package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.entities.Configuration;
import once.curso.proyectotienda.services.ConfigurationService;

@Data
@SpringBootTest
public class ConfigurationTest {

	@Autowired
	private ConfigurationService configurationService;
	
	public void findAll() {
		
		/*List<Configuration> dameConfiguraciones = (List<Configuration>getConfigurationService().findAll());
		assertNotEquals(dameConfiguraciones.size(),0);*/
	}

}
