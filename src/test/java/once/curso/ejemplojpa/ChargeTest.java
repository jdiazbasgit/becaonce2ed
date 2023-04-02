
package once.curso.ejemplojpa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Charge;
import once.curso.ejemplojpa.services.ChargeService;

@Data
@SpringBootTest
public class ChargeTest {
	
	@Autowired
	private ChargeService chargeService; //inyectamos del servicio porque de la clase del servicio es donde vamos a probar
	
	@Test //cada metodo que hagamos hay anotarle con @Test para indicar que es un Test.
	public void findAll() {
	
	List<Charge> cargos=(List<Charge>)getChargeService().findAll();
	assertNotEquals(cargos.size(),0);
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
