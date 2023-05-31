

package once.curso.proyectotienda.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.Rol;
import once.curso.proyectotienda.services.RolService;

@RestController
@Data
@RequestMapping("/v1/")
public class RolRestController {
	@Autowired
	private final RolService rolService;
	
	@GetMapping("/roles")
	public CollectionModel<Rol> findAll() {
	    Iterable<Rol> roles= getRolService().findAll();
	    roles.forEach(r->{
	    	r.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class).findById(r.getId())).withSelfRel());
	    });
	    return CollectionModel.of(roles);
	}
	
	@GetMapping("/roles/{id}")
	public EntityModel<Rol> findById(@PathVariable int id) {
		
		Rol rol= getRolService().findById(id).get();
		rol.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class).findById(rol.getId())).withSelfRel());
		return EntityModel.of(rol);
	}
}
