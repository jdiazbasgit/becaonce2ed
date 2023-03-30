package once.curso.ejemplojpa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Charge;
import once.curso.ejemplojpa.services.ChargeService;

@SpringBootTest
@Data
class ChargeTests {

	@Autowired
	private ChargeService ChargeService;
	
	@Test
	public void findAll() {
		List<Charge> cargos= (List<Charge>) getChargeService().findAll();
		assertNotEquals(cargos.size(), 0);
	}
	
	
	@Test
	public void probarSaveFindDelete() {
		
		Charge charge= new Charge();
		charge.setDescription("prueba");
		getChargeService().save(charge);
		Charge chargeRecuperado= getChargeService().findById(charge.getId()).get();
		getChargeService().delete(chargeRecuperado);
		
		assertFalse(getChargeService().findById(charge.getId()).isPresent());
		
	}
	
	
	
	
	
	
	
	
	

}
