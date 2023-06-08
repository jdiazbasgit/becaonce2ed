package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardsFinesConfiguration;
import once.curso.proyectobanco.services.AwardsFinesConfigurationServices;
import once.curso.proyectobanco.services.DescriptionService;

@SpringBootTest
@Data
public class AwardFineConfigurationTest {

	@Autowired
	private AwardsFinesConfigurationServices awardsFinesConfigurationServices;
	
	@Autowired
	private DescriptionService descriptionService;
	
	@Test
	public void findAll() {
		List<AwardsFinesConfiguration> awardsFinesConfigurations = (List<AwardsFinesConfiguration>) getAwardsFinesConfigurationServices().findAll();
		assertNotEquals(awardsFinesConfigurations.size(), 0);
	}

}
