package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardsFinesType;
import once.curso.proyectobanco.services.AwardsFinesTypeServices;
import once.curso.proyectobanco.services.DescriptionService;

@SpringBootTest
@Data
public class AwardFineTypeTest {

	@Autowired
	private AwardsFinesTypeServices awardsFinesTypeServices;

	@Autowired
	private DescriptionService descriptionService;

	@Test
	public void fidAll() {
		List<AwardsFinesType> awardsFinesTypes = (List<AwardsFinesType>) getAwardsFinesTypeServices().findAll();
		assertNotEquals(awardsFinesTypes.size(), 0);
	}
	
}
