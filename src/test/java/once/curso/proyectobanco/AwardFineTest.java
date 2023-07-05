package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardFine;
import once.curso.proyectobanco.entities.AwardFineConfiguration;
import once.curso.proyectobanco.entities.AwardFineType;
import once.curso.proyectobanco.services.AwardFineConfigurationService;
import once.curso.proyectobanco.services.AwardFineService;
import once.curso.proyectobanco.services.AwardFineTypeService;

@SpringBootTest
@Data
public class AwardFineTest {

	@Autowired
	private AwardFineService awardFineServices;

	@Autowired
	private AwardFineTypeService awardFineTypeServices;

	@Autowired
	private AwardFineConfigurationService awardFineConfigurationServices;

	@Test
	@Order(1)
	public void findAll() {
		List<AwardFine> awardFines = (List<AwardFine>) getAwardFineServices().findAll();
		assertNotEquals(awardFines.size(), 0);
	}

	@Test
	@Order(2)
	public void grabar() {
		AwardFineType awardFinesType = getAwardFineTypeServices().findById(1).get();
		AwardFineConfiguration awardFineConfiguration = getAwardFineConfigurationServices().findById(1).get();
		AwardFine awardFine = new AwardFine();
		awardFine.setAwardFineConfiguration(awardFineConfiguration);
		awardFine.setAwardFineType(awardFinesType);
		awardFine.setTime(35);
		getAwardFineServices().save(awardFine);
		assertNotEquals(awardFine.getId(), 0);

	}

	@Test
	@Order(3)
	public void testSaveAwardsFine() {
		AwardFine awardFine = new AwardFine();
		awardFine.setAwardFineConfiguration(getAwardFineConfigurationServices().findById(1).get());
		awardFine.setAwardFineType(getAwardFineTypeServices().findById(1).get());
		getAwardFineServices().save(awardFine);
		assertNotEquals(awardFine.getId(), 0);

	}

	@Test
	@Order(4)
	public void borraObjeto() {
		List<AwardFine> awardsFines = (List<AwardFine>) getAwardFineServices().findAll();

		List<AwardFine> borrarLosObjetos = new ArrayList<AwardFine>();
		borrarLosObjetos.add(awardsFines.get(0));
		borrarLosObjetos.add(awardsFines.get(1));
		borrarLosObjetos.add(awardsFines.get(2));
		getAwardFineServices().saveAll(borrarLosObjetos);

		getAwardFineServices().deleteAll(borrarLosObjetos);
		assertNotEquals(awardsFines.size(), 0);

	}

	@Test
	@Order(5)
	public void borraInteger() {
		List<AwardFine> awardsFines = (List<AwardFine>) getAwardFineServices().findAll();

		List<Integer> borrarLosObjetos = new ArrayList<Integer>();
		borrarLosObjetos.add(awardsFines.get(0).getId());
		borrarLosObjetos.add(awardsFines.get(1).getId());
		borrarLosObjetos.add(awardsFines.get(2).getId());

		getAwardFineServices().deleteAllById(borrarLosObjetos);
		
		awardsFines = (List<AwardFine>) getAwardFineServices().findAll();
		assertTrue(awardsFines.isEmpty());

		List<AwardFine> datosRecuperados = (List<AwardFine>) getAwardFineServices().findAll();
		
		for (AwardFine award : datosRecuperados) {
			System.out.println(award.toString());
		}
	}
}
