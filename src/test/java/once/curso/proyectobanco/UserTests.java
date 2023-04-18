package once.curso.proyectobanco;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.User;
import once.curso.proyectobanco.services.UserService;


@Data
@SpringBootTest
class UserTests {

	@Autowired
	private UserService userService;
	
	
	@Test
	public void findAll () {
		
		List<User> users= (List<User>) getUserService().findAll();
		assertNotEquals(users.size(), 0);
		
	}
	
	@Test
	public void findAllPassword () {
		
		List<User> users  = (List<User>) getUserService().findAll();
		for (User user : users) {
			
			System.out.println(user.getPassword());
			
		}
		
		
	
	}
}
