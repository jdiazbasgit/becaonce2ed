package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.Fee;
import once.curso.proyectobanco.services.FeeService;

@SpringBootTest
@Data
public class FeeTest {

	@Autowired
	private FeeService feeService;
	
	@Test
	public void findAll() {
		List<Fee> fees= (List<Fee>) getFeeService().findAll();
		assertNotEquals(fees.size(), 0);
	}
	
	
	@Test
	public void probarSaveFindDelete() {
		
		Fee fee= new Fee();
		fee.setCurrent(Math.random());
		getFeeService().save(fee);
		Fee feeRecuperado= getFeeService().findById(fee.getId()).get();
		getFeeService().delete(feeRecuperado);
		
		assertFalse(getFeeService().findById(fee.getId()).isPresent());
		
	}	
	
	
}