package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import once.curso.proyectobanco.entities.Rol;
import once.curso.proyectobanco.services.RolService;

@SpringBootTest
public class RolTest {
	@Autowired
	private RolService rolService;
	
	@Test
	public void testRol() {
		Iterable<Rol> roles=rolService.dameRoles();
		assertNotNull(roles);
	}

}
