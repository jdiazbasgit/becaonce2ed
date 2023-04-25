package once.curso.proyectotienda.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.Rol;
import once.curso.proyectotienda.services.RolService;

@RestController
@Data
public class RolRestController {
	@Autowired
	private final RolService rolService;
	
	@GetMapping("/rol")
	public Iterable<Rol> getRol() {
	    return rolService.findAll();
	}
}