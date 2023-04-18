package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.Configuration;
import once.curso.proyectobanco.services.ConfigurationService;
@Data
@SpringBootTest
public class ConfigurationTest {
	
	@Autowired
	private ConfigurationService configurationService;
	
	@Test
	public void findAll() {
		List<Configuration> configuration=(List<Configuration>) getConfigurationService().findAll();
		assertNotEquals(configuration.size(),0);
	}

}
