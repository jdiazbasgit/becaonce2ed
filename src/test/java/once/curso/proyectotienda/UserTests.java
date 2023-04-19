package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.entities.Rol;
import once.curso.proyectotienda.entities.User;
import once.curso.proyectotienda.services.RolService;
import once.curso.proyectotienda.services.UserService;

@SpringBootTest
@Data
public class UserTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RolService rolService;
	
	@Test
	public void probarSaveFindSaveDelete() {
		User user = new User();
		
		user.setUser("pruebas de usuario");
		user.setPassword("2468");
		user.setEnabled(true);
		user.setRolesId(getRolService().findById(1).get());
		
		getUserService().save(user);
		User userRecuperado = getUserService().findById(user.getId()).get();
		getUserService().delete(userRecuperado);
		
		assertFalse(getUserService().existsById(user.getId()));
		
	}
}
