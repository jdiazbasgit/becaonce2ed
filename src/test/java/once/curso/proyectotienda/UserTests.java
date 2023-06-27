package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
	
	
//	public void findAll() {
//		List<User> users = (List<User>) getUserService().findAll();
//		assertEquals(users.size(), 0);
//	}

//	@Test
//	public void saveUser() {
//	    User user = new User();
//
//	    user.setEnabled(true);
//	    user.setPassword("1234");
//	    user.setUser("ronald");
//	    
//	    // Obtener el rol del usuario (reemplaza el 1 con el ID correcto)
//	    Rol rol = getRolService().findById(27).orElse(null);
//	    if (rol != null) {
//	        user.setRol(rol);
//	    } else {
//	        throw new IllegalArgumentException("No se encontró el rol con el ID 1");
//	    }
//
//	    // Guardar el usuario en la base de datos
//	    getUserService().save(user);
//
//	    // Verificar si el usuario existe en la base de datos
//	    assertTrue(getUserService().existsById(user.getId()));
//
//	    // Eliminar el usuario de la base de datos
//	    getUserService().delete(user);
//
//	    // Verificar que el usuario ya no existe en la base de datos
//	    assertFalse(getUserService().existsById(user.getId()));
//	}

	@Test
	public void pruebaSaveAll() {

		long listado = getUserService().count();
		List<User> users = new ArrayList<>();

		User user1 = new User();

		user1.setUser("pruebas");
		user1.setPassword("8923");
		user1.setEnabled(true);
		user1.setRol(getRolService().findById(25).get());
		users.add(user1);

		User user2 = new User();

		user2.setUser("pruebas 2");
		user2.setPassword("6734");
		user2.setEnabled(true);
		user2.setRol(getRolService().findById(3).get());
		users.add(user2);

		getUserService().saveAll(users);
		assertEquals(getUserService().count(), listado + 2);

	}
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
