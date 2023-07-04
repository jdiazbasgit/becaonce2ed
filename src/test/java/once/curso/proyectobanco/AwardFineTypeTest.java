package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardFineType;
import once.curso.proyectobanco.services.AwardFineTypeService;

@SpringBootTest
@Data
public class AwardFineTypeTest {

	@Autowired
	private AwardFineTypeService awardFineTypeServices;


	@Test
	public void fidAll() {
		List<AwardFineType> awardsFinesTypes = (List<AwardFineType>) getAwardFineTypeServices().findAll();
		assertNotEquals(awardsFinesTypes.size(), 0);
			
	}
	
	@Test
	public void probarSave() {
		
		AwardFineType awardFineType = new AwardFineType();
		awardFineType.setDescription("prueba");
		getAwardFineTypeServices().save(awardFineType);
		AwardFineType awardsFinesTypeRecuperado = getAwardFineTypeServices().findById(awardFineType.getId()).get();
		
		assertTrue(getAwardFineTypeServices().findById(awardFineType.getId()).isPresent());
	}
	
	
}
