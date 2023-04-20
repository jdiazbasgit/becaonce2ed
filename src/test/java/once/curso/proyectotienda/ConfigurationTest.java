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
	public void probarSaveFindDelete() {
		Configuration configuration = new Configuration();
		configuration.setStockAlarm(1234);
		getConfigurationService().save(configuration);

		Configuration configurationRecuperado = getConfigurationService().findById(configuration.getId()).get();
		getConfigurationService().delete(configurationRecuperado);

		assertFalse(getConfigurationService().existsById(configuration.getId()));
	}
	
	@Order(2)
	@Test
	public void findAll() {
		List<Configuration> configurations = (List<Configuration>) getConfigurationService().findAll();
		assertNotEquals(configurations.size(), 1);
	}
	@Order(3)
	@Test
	public void SaveAll() {
		Long cantidadAlEmpezar = getConfigurationService().count();

		List<Configuration> configurations = new ArrayList<Configuration>();
		Configuration configurationPrueba1 = new Configuration();
		configurationPrueba1.setStockAlarm(1234);
		configurations.add(configurationPrueba1);

		getConfigurationService().saveAll(configurations);
		assertEquals(getConfigurationService().count(), cantidadAlEmpezar + 1);

	}

	@Order(4)
	@Test
	public void deleteAll() {

		Long cantidadAlEmpezar = getConfigurationService().count();
		List<Configuration> configurations = new ArrayList<Configuration>();
		Configuration configurationPrueba2 = new Configuration();
		configurationPrueba2.setStockAlarm(34);
		configurations.add(configurationPrueba2);

		getConfigurationService().deleteAll(configurations);
		assertNotEquals(getConfigurationService().count(), cantidadAlEmpezar + 0);
	}
	
	@Order(5)
	@Test
	public void existsById() {
		Configuration configuration = new Configuration();
		configuration.setStockAlarm(1234);
		getConfigurationService().existsById(1);
		assertFalse(getConfigurationService().existsById(configuration.getId()));

	}
	
	@Order(6)
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
	
	@Order(7)
	@Test
	public void count() {
		
		List<Configuration> configurations  = new ArrayList<Configuration>();
		
		Configuration configurationA = new Configuration();
		configurationA.setStockAlarm(1234);
		configurations.add(configurationA);
		
		Configuration configurationB = new Configuration();
		configurationB.setStockAlarm(1234);
		configurations.add(configurationB);
		configurationService.saveAll(configurations);
		
		long cantidad = configurationService.count();
		assertEquals(2, cantidad);
		
		configurations.forEach(configuration -> configurationService.deleteById(configuration.getId()));
		
	}

	
	
	
	
	
}
