package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.hibernate.EntityMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
	
	public CollectionModel<User> dameUser(){
		  Iterable<User> users= getUserService().findAll();
		  users.forEach(u->{
			  u.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class)
					  .findById(u.getRol().getId())).withRel("rol"));
			  u.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestControllers.class)
					  .findById(u.getId())).withSelfRel());
		  });
		  return CollectionModel.of(users);
	}
		
	@GetMapping("/users/{id}")
	public EntityModel<User> findById(@PathVariable Integer id) {
	User user= getUserService().findById(id).get();
	 user.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestControllers.class)
			  .findById(user.getId())).withSelfRel());
	return null;
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
