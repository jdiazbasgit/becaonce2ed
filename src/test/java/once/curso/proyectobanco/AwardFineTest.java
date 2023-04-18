package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardsFine;
import once.curso.proyectobanco.services.AwardsFinesServices;

@SpringBootTest
@Data
public class AwardFineTest {

	@Autowired
	private AwardsFinesServices AwardFineServices;
	
	@Test
	public void findAll() {
		List<AwardsFine> awardFines = (List<AwardsFine>) getAwardFineServices().findAll();
		assertNotEquals(awardFines.size(), 0);
	}
	
	
}
