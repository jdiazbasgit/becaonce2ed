package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	private UserService service;
	
	
	@PostMapping("/user")
	
	public List<User> dameUser(){
		 return (List<User>) getService().findAll();
	}
	

}
