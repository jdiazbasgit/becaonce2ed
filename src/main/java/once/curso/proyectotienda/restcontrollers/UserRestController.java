package once.curso.proyectotienda.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.User;
import once.curso.proyectotienda.service.UserService;

@RestController
@RequestMapping("/tienda")
@Data
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User save(@RequestBody User user) {
		return getUserService().save(user);
	}
	
	@GetMapping("/user")
	public Iterable<User> findAll(){
		return getUserService().findAll();
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteById(@PathVariable int id) {
		getUserService().deleteById(id);
	}
}
