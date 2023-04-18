package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
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

	@Test
	public void probarSaveFindDelete() {
		Configuration configuration = new Configuration();
		configuration.setStockAlarm(1234);
		getConfigurationService().save(configuration);

		Configuration configurationRecuperado = getConfigurationService().findById(configuration.getId()).get();
		getConfigurationService().delete(configurationRecuperado);

		assertFalse(getConfigurationService().existsById(configuration.getId()));
	}

}