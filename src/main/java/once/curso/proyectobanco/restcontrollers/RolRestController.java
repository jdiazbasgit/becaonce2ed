package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Rol;
import once.curso.proyectobanco.services.RolService;

@Data
@RestController
@RequestMapping("/once")
public class RolRestController {

	@Autowired
	private RolService rolService;

	@GetMapping(value = "/rol/{id}")
	public Rol findById(@PathVariable Integer id) {
		return getRolService().findById(id).get();
	}

	@GetMapping(value = "/rol")
	public Iterable<Rol> findAll(@PathVariable Integer id) {
		return getRolService().findAll();
	}

	@PostMapping(value = "/rol")
	public Rol save(@RequestBody Rol rol) {
		return getRolService().save(rol);
	}
	@PostMapping(value="/rol")
	public List<Rol> saveAll(@RequestBody List<Rol> rol){
		return (List<Rol>)getRolService().saveAll(rol);
	}
	@DeleteMapping(value="/rol/{id}")
	public void deleteById(@PathVariable Integer id) {
		getRolService().deleteById(id);
	}
}
