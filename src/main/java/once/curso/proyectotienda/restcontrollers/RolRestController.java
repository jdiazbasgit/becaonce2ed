package once.curso.proyectotienda.restcontrollers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
@RequestMapping("/tienda")
@RestController
public class RolRestController {

	private RolService rolservice;

	public RolService save(@RequestBody Rol rol) {
		return getRolService().findAll();
	}

	public void deleteById(@PathVariable int id) {
		getRolService().deleteById(id);
	}
}
