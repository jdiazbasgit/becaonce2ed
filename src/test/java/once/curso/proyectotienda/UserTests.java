package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
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
	
	
//	public void findAll() {
//		List<User> users = (List<User>) getUserService().findAll();
//		assertEquals(users.size(), 0);
//	}

	@Test
	public void saveUser() {
		
		User user = new User();

		user.setUser("pruebas de usuario");
		user.setPassword("2468");
		user.setEnabled(true);
		user.setRol(getRolService().findById(3).get());

		getUserService().save(user);
		getUserService().deleteById(user.getId());

		assertFalse(getUserService().existsById(user.getId()));
		
		
	}

//	@Test
//	public void pruebaSaveAll() {
//
//		long listado = getUserService().count();
//		List<User> users = new ArrayList<>();
//
//		User user1 = new User();
//
//		user1.setUser("pruebas");
//		user1.setPassword("8923");
//		user1.setEnabled(true);
//		user1.setRolesId(getRolService().findById(3).get());
//		users.add(user1);
//
//		User user2 = new User();
//
//		user2.setUser("pruebas 2");
//		user2.setPassword("6734");
//		user2.setEnabled(true);
//		user2.setRolesId(getRolService().findById(3).get());
//		users.add(user2);
//
//		getUserService().saveAll(users);
//		assertEquals(getUserService().count(), listado + 2);
//
//	}
//	@Test
//	public void pruebaDeleteAll() {
//
//		long listado = getUserService().count();
//		List<User> users = new ArrayList<>();
//
//		User user1 = new User();
//
//		user1.setUser("pruebas");
//		user1.setPassword("8923");
//		user1.setEnabled(true);
//		user1.setRolesId(getRolService().findById(3).get());
//		users.add(user1);
//
//		User user2 = new User();
//
//		user2.setUser("pruebas 2");
//		user2.setPassword("6734");
//		user2.setEnabled(true);
//		user2.setRolesId(getRolService().findById(3).get());
//		users.add(user2);
//
//		getUserService().saveAll(users);
//		assertEquals(getUserService().count(), listado + 2);
//
//		List<Integer> num = new ArrayList<Integer>();
//
//		num.add(user1.getId());
//		num.add(user2.getId());
//
//		getUserService().deleteAllById(num);
//
//		assertEquals(listado, getUserService().count());
//
//	}
}
