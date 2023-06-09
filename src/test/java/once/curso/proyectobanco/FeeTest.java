package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import once.curso.proyectobanco.entities.Fee;
import once.curso.proyectobanco.services.FeeService;

@SpringBootTest
@Data
@TestMethodOrder(OrderAnnotation.class)
public class FeeTest {

	@Autowired
	private FeeService feeService;
	
	private static List<Fee> fees = new ArrayList<Fee>();
	private static int numeroDeEntradas = 5; 
	
	//public FeeTest() {
		//if (FeeTest.fees.size() == 0)
		//generarVariables();
	//}
	
	@BeforeAll
	public static void generarVariables() {
		if (numeroDeEntradas < 3)
			numeroDeEntradas = 3;
		for (int i = 0; i < numeroDeEntradas; i++) {
			Fee fee = new Fee();
			fee.setCurrent(Math.random());
			FeeTest.fees.add(fee);
		}	   
	}

	@Order(1)
	@Test
	public void saveTest() {		
	    getFeeService().save(FeeTest.fees.get(0));
	    assertTrue(getFeeService().findById(FeeTest.fees.get(0).getId()).isPresent());		
	}
	
	@Order(2)
	@Test
	public void existsByIdTest() {		
	    assertTrue(getFeeService().existsById((FeeTest.fees.get(0).getId())));		
	}
		

	@Order(4)
	@Test
	public void deleteByIdTest() {
	    Fee feeRecuperado= getFeeService().findById(FeeTest.fees.get(0).getId()).get();
	    getFeeService().deleteById(feeRecuperado.getId());
	    FeeTest.fees.remove(0);
	    assertFalse(getFeeService().findById(feeRecuperado.getId()).isPresent());		
	}
	
	@Order(3)
	@Test
	public void saveAllTest() {
	    getFeeService().saveAll(fees);
	    List<Integer> idsAComprobar = new ArrayList<Integer>();
	    for (Fee fee : fees) {
			idsAComprobar.add(fee.getId());
		}
	    assertEquals(FeeTest.fees.size(), ((List<?>) getFeeService().findAllById(idsAComprobar)).size());
	}
	
	@Order(5)
	@Test
	public void countTest() {
		assertEquals(((List<?>) getFeeService().findAll()).size(), getFeeService().count());
	}
	
	
	@Order(6)
	@Test
	public void deleteEntity() {
		Fee entradaAComprobar = getFeeService().findById(FeeTest.fees.get(0).getId()).get();
		getFeeService().delete(getFeeService().findById(FeeTest.fees.get(0).getId()).get());
	    FeeTest.fees.remove(0);
	    assertFalse(getFeeService().findById(entradaAComprobar.getId()).isPresent());
	    
	}
	
	@Order(7)
	@Test
	public void deleteAllByIdTest() {
		List<Integer> idsABorrar = new ArrayList<Integer>();
	    for (Fee fee : fees) {
	    	idsABorrar.add(fee.getId());
		}
	    getFeeService().deleteAllById(idsABorrar);
	    assertEquals(0, ((List<?>) getFeeService().findAllById(idsABorrar)).size());
	}

	
	
	
	
	
	//Probando cómo sacar la entity, Before es de JUnit pero necesita dependencia en el pom :(
		/*<dependency>
	    <groupId>junit</groupId>
	    <artifactId>junit</artifactId>
	    <version>4.13.2</version>
	    <scope>test</scope>
	    </dependency>*/
	
	
	//@Test
	public void findAll() {
		Fee fee= new Fee();
		fee.setCurrent(Math.random());
		getFeeService().save(fee);
		
		Fee fee2= new Fee();
		fee.setCurrent(Math.random());
		getFeeService().save(fee2);
		
		List<Fee> fees= (List<Fee>) getFeeService().findAll();
		assertNotEquals(FeeTest.fees.size(), 0);
		
		Fee feeRecuperado= getFeeService().findById(fee.getId()).get();
		getFeeService().delete(feeRecuperado);
		Fee feeRecuperado2= getFeeService().findById(fee2.getId()).get();
		getFeeService().delete(feeRecuperado2);
		
	}
	
	//@Test
	public void probarSaveFindDelete() {
		
		Fee fee= new Fee();
		fee.setCurrent(Math.random());
		getFeeService().save(fee);
		Fee feeRecuperado= getFeeService().findById(fee.getId()).get();
		getFeeService().delete(feeRecuperado);
		
		assertFalse(getFeeService().findById(fee.getId()).isPresent());
		
	}	
	
	
}