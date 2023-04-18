package once.curso.proyectobanco.restcontrollers;

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
import once.curso.proyectobanco.entities.User;
import once.curso.proyectobanco.services.UserService;


@Data
@RestController
@RequestMapping("/once")
public class UserRestControllers {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	
	public List<User> dameUser(){
		 return (List<User>) getUserService().findAll();
	}
		
	@GetMapping("/users/{id}")
	public User findById(@PathVariable Integer id) {
	return getUserService().findById(id).get();
	}
	
	@PostMapping("/users")
	public User save(@RequestBody User user){
		return getUserService().save(user);
	}
	
	@PutMapping("/users")
	public List<User> saveAll(@RequestBody List<User> users){
		return (List<User>) getUserService().saveAll(users);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable int id) {
		 getUserService().deleteById(id);
	}
	
}
