package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		assertNotEquals(0, configurations.size()); // TestFindId
		
	}

	@Order(2)
	@Test
	public void testExistsById() {

		Configuration configurationPrueba = new Configuration();
		configurationPrueba.setStockAlarm(1111);
		getConfigurationService().save(configurationPrueba);

		Integer numero = configurationPrueba.getId();
		System.out.println("numero: "+numero);
		assertTrue(getConfigurationService().existsById(numero)); //TestExists

	}

	@Order(3)
	@Test
	public void testSaveFindDeleteId() {
		
		Long contadorRegistro = getConfigurationService().count();

		Configuration configurationNuevo = new Configuration();
		configurationNuevo.setStockAlarm(2222);
		contadorRegistro++;

		getConfigurationService().save(configurationNuevo);
		assertEquals(contadorRegistro, getConfigurationService().count()); //TestSave
		
		Configuration configurationRecuperado = getConfigurationService().findById(configurationNuevo.getId()).get();
		assertEquals(configurationNuevo.getStockAlarm(), configurationRecuperado.getStockAlarm()); //TestFind
		contadorRegistro--;

		getConfigurationService().delete(configurationRecuperado);
		assertEquals(contadorRegistro, getConfigurationService().count()); //TestDelete

	}

	@Order(4)
	@Test
	public void testSaveFindDeleteAll() {
		
		Long contadorRegistro = getConfigurationService().count();

		List<Configuration> configurations = new ArrayList<Configuration>();

		Configuration configurationNuevo1 = new Configuration();
		configurationNuevo1.setStockAlarm(3333);
		configurations.add(configurationNuevo1);
		contadorRegistro++;

		Configuration configurationNuevo2 = new Configuration();
		configurationNuevo2.setStockAlarm(4444);
		configurations.add(configurationNuevo2);
		contadorRegistro++;

		getConfigurationService().saveAll(configurations);
		assertEquals(contadorRegistro, getConfigurationService().count()); //TestSaveAll
		
		List<Integer> numeros = new ArrayList<Integer>();
		
		numeros.add(configurationNuevo1.getId());
		contadorRegistro--;
		
		numeros.add(configurationNuevo2.getId());
		contadorRegistro--;

		List<Configuration> configurationRecuperado = (List<Configuration>) getConfigurationService().findAllById(numeros);
		assertEquals(numeros.size(), configurationRecuperado.size()); //TestFindAll
		contadorRegistro--;
		
		getConfigurationService().deleteAllById(numeros);
		
		assertEquals(contadorRegistro, getConfigurationService().count()); //TestDeleteAll
		
	}

	@Order(5)
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

	@Order(6)
	@Test
	public void DelAllConfiguration() {
		/*
		 * getConfigurationService().deleteAll(); assertEquals(0,
		 * getConfigurationService().count());
		 */
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
