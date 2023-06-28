package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.entities.Configuration;
import once.curso.proyectotienda.services.ConfigurationService;

@Data
@SpringBootTest
@TestClassOrder(value = OrderAnnotation.class)
public class ConfigurationTest {

	@Autowired
	private ConfigurationService configurationService;

	@Order(1)
	@Test
	public void testFindAll() {
		List<Configuration> configurations = (List<Configuration>) getConfigurationService().findAll();
		assertNotEquals(0, configurations.size());
	}

	@Order(2)
	@Test
	public void testSaveFindDeleteId() {
		Long contadorRegistro = getConfigurationService().count();

		Configuration configurationNuevo = new Configuration();
		configurationNuevo.setStockAlarm(1111);
		contadorRegistro++;

		getConfigurationService().save(configurationNuevo);
		assertEquals(contadorRegistro, getConfigurationService().count());
		
		Configuration configurationRecuperado = getConfigurationService().findById(configurationNuevo.getId()).get();
		contadorRegistro--;
		getConfigurationService().delete(configurationRecuperado);
		assertEquals(contadorRegistro, getConfigurationService().count());

	}

	@Order(3)
	@Test
	public void testSaveAll() {
		Long contadorRegistro = getConfigurationService().count();

		List<Configuration> configurations = new ArrayList<Configuration>();

		Configuration configurationNuevo1 = new Configuration();
		configurationNuevo1.setStockAlarm(2222);
		configurations.add(configurationNuevo1);
		contadorRegistro++;

		Configuration configurationNuevo2 = new Configuration();
		configurationNuevo2.setStockAlarm(3333);
		configurations.add(configurationNuevo2);
		contadorRegistro++;

		getConfigurationService().saveAll(configurations);
		assertEquals(contadorRegistro, getConfigurationService().count());
		
		List<Integer> numeros = new ArrayList<Integer>();
		
		numeros.add(configurationNuevo1.getId());
		contadorRegistro--;
		
		numeros.add(configurationNuevo2.getId());
		contadorRegistro--;

		getConfigurationService().deleteAllById(numeros);
		
		assertEquals(contadorRegistro, getConfigurationService().count());
	}

	@Order(4)
	@Test
	public void deleteByIDConfiguration() {
		/*
		 * Configuration configuration = new Configuration();
		 * configuration.setStockAlarm(1234);
		 * getConfigurationService().save(configuration);
		 * 
		 * Configuration configurationRecuperado =
		 * getConfigurationService().findById(configuration.getId()).get();
		 * getConfigurationService().delete(configurationRecuperado);
		 * 
		 * assertFalse(getConfigurationService().existsById(configuration.getId()));
		 */

		int numID = 228;
		Configuration configuration = getConfigurationService().findById(numID).orElse(null);
		if (configuration != null) {
			getConfigurationService().delete(configuration);
		}
	}

	/*
	 * @Order(4)
	 * 
	 * @Test public void deleteAll() {
	 * 
	 * Long cantidadAlEmpezar = getConfigurationService().count();
	 * List<Configuration> configurations = new ArrayList<Configuration>();
	 * Configuration configurationPrueba2 = new Configuration();
	 * configurationPrueba2.setStockAlarm(34);
	 * configurations.add(configurationPrueba2);
	 * 
	 * getConfigurationService().deleteAll(configurations);
	 * assertNotEquals(getConfigurationService().count(), cantidadAlEmpezar + 0); }
	 */

	@Order(5)
	@Test
	public void DelAllConfiguration() {
		/*
		 * getConfigurationService().deleteAll(); assertEquals(0,
		 * getConfigurationService().count());
		 */
	}

	@Order(6)
	@Test
	public void existsById() {
		 //int numID = 229;
		Configuration configuration = new Configuration();
		configuration.setStockAlarm(1234);
		getConfigurationService().existsById(229);
		//getConfigurationService().save(configuration);
		assertFalse(getConfigurationService().existsById(configuration.getId()));

	}

	@Order(7)
	@Test
	public void findAllById() {

		List<Configuration> configurations = (List<Configuration>) getConfigurationService().findAll();
		List<Integer> idsQueCompruebo = new ArrayList<Integer>();
		for (Configuration configurationQueCompruebo : configurations) {
			idsQueCompruebo.add(configurationQueCompruebo.getId());
		}
		assertEquals(configurations.size(),
				((List<Configuration>) getConfigurationService().findAllById(idsQueCompruebo)).size());

	}

	@Order(8)
	@Test
	public void count() {

		/*
		 * List<Configuration> configurations = new ArrayList<Configuration>();
		 * 
		 * Configuration configurationA = new Configuration();
		 * configurationA.setStockAlarm(1234); configurations.add(configurationA);
		 * 
		 * Configuration configurationB = new Configuration();
		 * configurationB.setStockAlarm(1234); configurations.add(configurationB);
		 * configurationService.saveAll(configurations);
		 */

		/*
		 * long cantidad = configurationService.count(); assertEquals(2, cantidad);
		 */

		// configurations.forEach(configuration ->
		// configurationService.deleteById(configuration.getId()));

	}

	@Order(9)
	@Test
	public void findById() {

		/*
		 * Configuration configuration = new Configuration();
		 * configuration.setStockAlarm(1234);
		 * getConfigurationService().save(configuration);
		 * 
		 * Configuration dConfigurationRecuperado =
		 * getConfigurationService().findById(configuration.getId()).orElse(null);
		 * assertNotNull(getConfigurationService().findById(dConfigurationRecuperado.
		 * getId()).orElse(null));
		 * getConfigurationService().delete(dConfigurationRecuperado);
		 */

	}

}
