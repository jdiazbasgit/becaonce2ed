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
	private AwardsFinesServices awardsFinesServices;

	@Autowired
	private AwardsFinesTypeServices awardsFinesTypeServices;

	@Autowired
	private AwardsFinesConfigurationServices awardsFinesConfigurationServices;

	@Test
	@Order(1)
	public void findAll() {
		List<AwardsFine> awardFines = (List<AwardsFine>) getAwardsFinesServices().findAll();
		assertNotEquals(awardFines.size(), 0);
	}

	@Test
	@Order(2)
	public void grabar() {
		AwardsFinesType awardsFinesType = getAwardsFinesTypeServices().findById(1).get();
		AwardsFinesConfiguration awardsFinesConfiguration = getAwardsFinesConfigurationServices().findById(1).get();
		AwardsFine awardsFine = new AwardsFine();
		awardsFine.setAwardFineConfiguration(awardsFinesConfiguration);
		awardsFine.setAwardFineType(awardsFinesType);
		awardsFine.setTime(35);
		getAwardsFinesServices().save(awardsFine);
		assertNotEquals(awardsFine.getId(), 0);

	}

	@Test
	@Order(3)
	public void testSaveAwardsFine() {
		AwardsFine awardsFine = new AwardsFine();
		awardsFine.setAwardFineConfiguration(getAwardsFinesConfigurationServices().findById(1).get());
		awardsFine.setAwardFineType(getAwardsFinesTypeServices().findById(1).get());
		getAwardsFinesServices().save(awardsFine);
		assertNotEquals(awardsFine.getId(), 0);

	}

	@Test
	@Order(4)
	public void borraObjeto() {
		List<AwardsFine> awardsFines = (List<AwardsFine>) getAwardsFinesServices().findAll();

		List<AwardsFine> borrarLosObjetos = new ArrayList<AwardsFine>();
		borrarLosObjetos.add(awardsFines.get(0));
		borrarLosObjetos.add(awardsFines.get(1));
		borrarLosObjetos.add(awardsFines.get(2));
		getAwardsFinesServices().saveAll(borrarLosObjetos);

		getAwardsFinesServices().deleteAll(borrarLosObjetos);
		assertNotEquals(awardsFines.size(), 0);

	}

	@Test
	@Order(5)
	public void borraInteger() {
		List<AwardsFine> awardsFines = (List<AwardsFine>) getAwardsFinesServices().findAll();

		List<Integer> borrarLosObjetos = new ArrayList<Integer>();
		borrarLosObjetos.add(awardsFines.get(0).getId());
		borrarLosObjetos.add(awardsFines.get(1).getId());
		borrarLosObjetos.add(awardsFines.get(2).getId());

		getAwardsFinesServices().deleteAllById(borrarLosObjetos);
		
		awardsFines = (List<AwardsFine>) getAwardsFinesServices().findAll();
		assertTrue(awardsFines.isEmpty());

		List<AwardsFine> datosRecuperados = (List<AwardsFine>) getAwardsFinesServices().findAll();
		
		for (AwardsFine award : datosRecuperados) {
			System.out.println(award.toString());
		}
	}
}
