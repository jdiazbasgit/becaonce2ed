package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.Fee;
import once.curso.proyectobanco.entities.Profile;
import once.curso.proyectobanco.services.FeeService;
import once.curso.proyectobanco.services.ProfileService;

@SpringBootTest
@Data
public class FeeTest {

	@Autowired
	private FeeService feeService;
	
	
	//Probando a cómo sacar la entity
	private Fee fee = new Fee();
	
	@Test
	public void saveTest() {
		//Fee fee= new Fee();
		fee.setCurrent(Math.random());
		getFeeService().save(fee);
		assertTrue(getFeeService().findById(fee.getId()).isPresent());
		
	}
	
	@Test
	public void deleteByIdTest() {
		Fee feeRecuperado= getFeeService().findById(fee.getId()).get();
		getFeeService().delete(feeRecuperado);
		assertFalse(getFeeService().findById(feeRecuperado.getId()).isPresent());
		
	}
	
	//@Test
	public void findAll() {
		Fee fee= new Fee();
		fee.setCurrent(Math.random());
		getFeeService().save(fee);
		
		Fee fee2= new Fee();
		fee.setCurrent(Math.random());
		getFeeService().save(fee2);
		
		List<Fee> fees= (List<Fee>) getFeeService().findAll();
		assertNotEquals(fees.size(), 0);
		
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