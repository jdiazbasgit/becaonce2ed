package once.curso.banco;
/*
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;

@SpringBootTest
@Data
class PruebaTest {

	@Autowired
	private RolService rolService;
	
	@Test
	public void findAll() {
		List<Rol> cargos= (List<Rol>) getRolService().findAll();
		assertNotEquals(cargos.size(), 0);
	}
	
	
	@Test
	public void probarSaveFindDelete() {
		
		Rol charge= new Rol();
		charge.setRol("prueba");
		getRolService().save(charge);
		Rol chargeRecuperado= getRolService().findById(charge.getId()).get();
		getRolService().delete(chargeRecuperado);
		
		assertFalse(getRolService().findById(charge.getId()).isPresent());
		
	}	

}*/