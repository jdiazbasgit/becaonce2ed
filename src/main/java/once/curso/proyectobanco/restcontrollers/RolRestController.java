package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcAffordanceBuilderDsl;
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
import once.curso.proyectobanco.entities.Rol;
import once.curso.proyectobanco.services.RolService;

@Data
@RestController
@RequestMapping("/once")
public class RolRestController {

	@Autowired
	private RolService rolService;

	@GetMapping(value = "/roles/{id}")
	public EntityModel<Rol> findById(@PathVariable int id) {
		Rol rol=  getRolService().findById(id).get();
		rol.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class)
				.findById(rol.getId())).withSelfRel());
		 return EntityModel.of(rol);
	}

	@GetMapping(value = "/roles")
	public CollectionModel<Rol> findAll() {
		 Iterable<Rol> roles= getRolService().findAll();
		 roles.forEach(r->{
			 r.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class)
					 .findById(r.getId())).withSelfRel());
		 });
		 return CollectionModel.of(roles);
	}

	@PostMapping(value = "/roles")
	public Rol save(@RequestBody Rol rol) {
		return getRolService().save(rol);
	}
	@PutMapping(value="/roles")
	public List<Rol> saveAll(@RequestBody List<Rol> rol){
		return (List<Rol>)getRolService().saveAll(rol);
	}
	@DeleteMapping(value="/roles/{id}")
	public void deleteById(@PathVariable Integer id) {
		getRolService().deleteById(id);
	}
}
