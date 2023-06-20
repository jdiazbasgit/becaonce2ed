package once.curso.proyectobanco;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
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
	public void saveUser() {
		
		User user = new User();
		user.setUser("prueba");
		user.setPassword("12344");
		user.setEnabled(true);
		user.setRol(getRolService().findById(2).get());

		
		getUserService().save(user);
		getUserService().deleteById(user.getId());
		assertFalse(getUserService().existsById(user.getId()));
		 	
	}
	@Test
	public void findAll () {
		
		List<User> users= (List<User>) getUserService().findAll();
		assertNotEquals(users.size(),0);
		
	}
	
	@Test
	public void saveAllUsers() {
		long cantidadAlEmpezar=getUserService().count();
	    List<User> users = new ArrayList<>();
	   User user1= new User();
	   user1.setUser("prueba42");
	   user1.setPassword("4321");
	   user1.setEnabled(true);
	   user1.setRol(getRolService().findById(2).get());
	   users.add(user1);
	    
	   User user2 =new User();
	   user2.setUser("prueba43");
	   user2.setPassword("1234");
	   user2.setEnabled(true);
	   user2.setRol(getRolService().findById(3).get());
	   users.add(user2);
	   
	   getUserService().saveAll(users);
	   
	   assertEquals(getUserService().count(),cantidadAlEmpezar+2);
	   getUserService().deleteAll(users);
	}
	 @Test
	 public void delete() {
		 
		 	User userdelete = new User();
		 	userdelete.setUser("pepe");
		 	userdelete.setPassword("0987");
		 	userdelete.setEnabled(true);
		 	userdelete.setRol(getRolService().findById(3).get());
		 	getUserService().save(userdelete);
		 	getUserService().delete(userdelete);
		 	//assertTrue(true.getUserService().delete(userdelete));
	 }
}
