package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.Rol;
import once.curso.proyectobanco.services.RolService;

@SpringBootTest
@Data
public class RolTest {
	@Autowired
	private RolService rolService;
	
	@Test
	public void testRol() {
		List<Rol> roles=(List<Rol>) rolService.findAll();
		assertNotEquals(roles.size(), 0);
	}
	
	@Test
	public void testSaveRol() {
		Rol rol = new Rol();
		rol.setRol("prueba oscar");
		getRolService().save(rol);
		assertTrue(getRolService().existsById(rol.getId()));
	}
	@Test
	public void testDeleteRol() {
	
	}
}
