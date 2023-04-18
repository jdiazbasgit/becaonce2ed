package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardFine;
import once.curso.proyectobanco.services.AwardFineServices;

@SpringBootTest
@Data
public class AwardFineTest {

	@Autowired
	private AwardFineServices AwardFineServices;
	
	@Test
	public void findAll() {
		List<AwardFine> awardFines = (List<AwardFine>) getAwardFineServices().findAll();
		assertNotEquals(awardFines.size(), 0);
	}
	
	@Test
	public void probarSaveFinDelete() {
		AwardFine awardFine = new AwardFine();
		awardFine.setAwardFineConfiguration("prueba");
		getAwardFineServices().save(awardFine);
		AwardFine awardFineRecuperado = getAwardFineServices().findById(AwardFine.getId()).get();
		getAwardFineServices().delete(awardFineRecuperado);
		AwardFine awardFineB
	}
}
