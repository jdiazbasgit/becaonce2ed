package once.curso.proyectobanco;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.User;
import once.curso.proyectobanco.services.RolService;
import once.curso.proyectobanco.services.UserService;


@Data
@SpringBootTest
class UserTests {

	@Autowired
	private UserService userService;
	@Autowired
	private RolService rolService;
	
	@Test
	public void findAll () {
		
		List<User> users= (List<User>) getUserService().findAll();
		assertNotEquals(users.size(),0);
		
	}
	
	
	@Test
	public void grabarUser() {
		
		User user = new User();
		user.setUser("prueba");
		user.setPassword("12344");
		user.setEnabled(true);
		user.setRol(getRolService().findById(2).get());
		user.setId(0);
		
		getUserService().save(user);
		getUserService().deleteById(user.getId());
		assertFalse(getUserService().existsById(user.getId()));
		 
		
	
		
	}
}
