package once.curso.proyectotienda.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.User;
import once.curso.proyectotienda.services.UserService;

@RestController
@RequestMapping("/once")
@Data
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> dameUser(){
		return (List<User>) getUserService().findAll();
	}
	
	@GetMapping("/users{id}")
	public User findById(@PathVariable Integer id) {
		return getUserService().findById(id).get();
	}
	
	@GetMapping("/user")
	public Iterable<User> findAll(){
		return getUserService().findAll();
	}
	
	@PostMapping("/users")
	public User save(@RequestBody User user) {
		return getUserService().save(user);
	}
	
	@PutMapping("/users")
	public List<User> saveAll (@RequestBody List<User> users){
		return (List<User>) getUserService().saveAll(users);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteById(@PathVariable int id) {
		getUserService().deleteById(id);
	}
}
