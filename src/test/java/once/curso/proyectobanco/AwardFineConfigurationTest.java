package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardFineConfiguration;
import once.curso.proyectobanco.services.AwardFineConfigurationService;
import once.curso.proyectobanco.services.DescriptionService;

@SpringBootTest
@Data
public class AwardFineConfigurationTest {

	@Autowired
	private AwardFineConfigurationService awardsFinesConfigurationServices;
	
	@Autowired
	private DescriptionService descriptionService;
	
	@Test
	public void findAll() {
		List<AwardFineConfiguration> awardsFinesConfigurations = (List<AwardFineConfiguration>) getAwardsFinesConfigurationServices().findAll();
		assertNotEquals(awardsFinesConfigurations.size(), 0);
	}

}
