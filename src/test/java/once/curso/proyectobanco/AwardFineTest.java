package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardsFine;
import once.curso.proyectobanco.entities.AwardsFinesConfiguration;
import once.curso.proyectobanco.entities.AwardsFinesType;
import once.curso.proyectobanco.services.AwardsFinesConfigurationServices;
import once.curso.proyectobanco.services.AwardsFinesServices;
import once.curso.proyectobanco.services.AwardsFinesTypeServices;

@SpringBootTest
@Data
public class AwardFineTest {

	@Autowired
	private AwardsFinesServices AwardFineServices;
	
	@Autowired
	private AwardsFinesTypeServices awardsFinesTypeServices;
	
	@Autowired
	private AwardsFinesConfigurationServices awardsFinesConfigurationServices;
	
	@Test
	public void findAll() {
		List<AwardsFine> awardFines = (List<AwardsFine>) getAwardFineServices().findAll();
		assertNotEquals(awardFines.size(), 0);
	}
	
	@Test
	public void grabar() {
		AwardsFinesType awardsFinesType=getAwardsFinesTypeServices().findById(1).get();
		AwardsFinesConfiguration awardsFinesConfiguration=getAwardsFinesConfigurationServices().findById(1).get();
		AwardsFine awardsFine= new AwardsFine();
		awardsFine.setAwardFineConfiguration(awardsFinesConfiguration);
		awardsFine.setAwardFineType(awardsFinesType);
		awardsFine.setTime(35);		
		getAwardFineServices().save(awardsFine);
		assertNotEquals(awardsFine.getId(), 0);
		
	}
	
	
}
