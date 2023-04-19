package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.IdentificationType;
import once.curso.proyectobanco.services.IdentificationTypeService;

@SpringBootTest
@Data
@TestMethodOrder(OrderAnnotation.class)
public class IdentificationTypeTest {

	@Autowired
	private IdentificationTypeService identificationTypeService;
	
	private static List<IdentificationType> identificationType = new ArrayList<IdentificationType>();
	private static int numeroDeEntradas = 5; 
	
	
	@BeforeAll
	public static void generarVariables() {
		if (numeroDeEntradas < 3)
			numeroDeEntradas = 3;
		for (int i = 0; i < numeroDeEntradas; i++) {
			IdentificationType identificationType = new IdentificationType();
			identificationType.setDescription("Prueba"+i);
			IdentificationTypeTest.identificationType.add(identificationType);
		}	   
	}

	@Order(1)
	@Test
	public void saveTest() {		
	    getIdentificationTypeService().save(IdentificationTypeTest.identificationType.get(0));
	    assertTrue(getIdentificationTypeService().findById(IdentificationTypeTest.identificationType.get(0).getId()).isPresent());		
	}
	
	@Order(2)
	@Test
	public void existsByIdTest() {		
	    assertTrue(getIdentificationTypeService().existsById((IdentificationTypeTest.identificationType.get(0).getId())));		
	}

	@Order(3)
	@Test
	public void deleteByIdTest() {
	    IdentificationType IdentificationTypeRecuperado= getIdentificationTypeService().findById(IdentificationTypeTest.identificationType.get(0).getId()).get();
	    getIdentificationTypeService().deleteById(IdentificationTypeRecuperado.getId());
	    IdentificationTypeTest.identificationType.remove(0);
	    assertFalse(getIdentificationTypeService().findById(IdentificationTypeRecuperado.getId()).isPresent());		
	}
	
	@Order(4)
	@Test
	public void saveAllTest() {
	    getIdentificationTypeService().saveAll(identificationType);
	    List<Integer> idsAComprobar = new ArrayList<Integer>();
	    for (IdentificationType IdentificationType : identificationType) {
			idsAComprobar.add(IdentificationType.getId());
		}
	    assertEquals(IdentificationTypeTest.identificationType.size(), ((List<?>) getIdentificationTypeService().findAllById(idsAComprobar)).size());
	}
	
	@Order(5)
	@Test
	public void countTest() {
		assertEquals(((List<?>) getIdentificationTypeService().findAll()).size(), getIdentificationTypeService().count());
	}
		
	@Order(6)
	@Test
	public void deleteEntity() {
		IdentificationType entradaAComprobar = getIdentificationTypeService().findById(IdentificationTypeTest.identificationType.get(0).getId()).get();
		getIdentificationTypeService().delete(getIdentificationTypeService().findById(IdentificationTypeTest.identificationType.get(0).getId()).get());
	    IdentificationTypeTest.identificationType.remove(0);
	    assertFalse(getIdentificationTypeService().findById(entradaAComprobar.getId()).isPresent());	    
	}
	
	@Order(7)
	@Test
	public void deleteAllByIdTest() {
		List<Integer> idsABorrar = new ArrayList<Integer>();
	    for (IdentificationType IdentificationType : identificationType) {
	    	idsABorrar.add(IdentificationType.getId());
		}
	    getIdentificationTypeService().deleteAllById(idsABorrar);
	    assertEquals(0, ((List<?>) getIdentificationTypeService().findAllById(idsABorrar)).size());
	}	
}