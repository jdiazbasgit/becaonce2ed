package once.curso.proyectobanco.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Rol;
import once.curso.proyectobanco.services.RolService;

@Data
@RestController
@RequestMapping ("/once")
public class RolRestController {
	
	@Autowired
	private RolService rolService;
	
	@GetMapping(value="/rol/{id}")
	public Rol findById(@PathVariable Integer id) {
		return getRolService().findById(id).get();
	}

}
