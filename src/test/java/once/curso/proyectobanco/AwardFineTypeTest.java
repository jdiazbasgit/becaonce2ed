package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardsFinesType;
import once.curso.proyectobanco.services.AwardsFinesTypeServices;

@SpringBootTest
@Data
public class AwardFineTypeTest {

	@Autowired
	private AwardsFinesTypeServices awardsFinesTypeServices;


	@Test
	public void fidAll() {
		List<AwardsFinesType> awardsFinesTypes = (List<AwardsFinesType>) getAwardsFinesTypeServices().findAll();
		assertNotEquals(awardsFinesTypes.size(), 0);
			
	}
	
	@Test
	public void probarSave() {
		
		AwardsFinesType awardFineType = new AwardsFinesType();
		awardFineType.setDescription("prueba");
		getAwardsFinesTypeServices().save(awardFineType);
		AwardsFinesType awardsFinesTypeRecuperado = getAwardsFinesTypeServices().findById(awardFineType.getId()).get();
		
		assertTrue(getAwardsFinesTypeServices().findById(awardFineType.getId()).isPresent());
	}
	
	
}
