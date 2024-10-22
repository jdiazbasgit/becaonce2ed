package once.curso.proyectotienda.restcontrollers;

import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.Rol;
import once.curso.proyectotienda.model.RolModelAssembler;
import once.curso.proyectotienda.services.RolService;

@RestController
@Data
@RequestMapping("/once")
public class RolRestController {
	
	@Autowired
	private final RolService rolService;
	
	@Autowired
	private PagedResourcesAssembler<Rol> pagedResourcesAssembler;
	
	@Autowired
	private RolModelAssembler rolModelAssembler;
	
	@GetMapping("/roles")
	@CrossOrigin(origins = "*")
	public CollectionModel<Rol> findAll() {
	    Iterable<Rol> roles= getRolService().findAll();
	    roles.forEach(r->{
	    	r.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class).findById(r.getId())).withSelfRel());
	    });
	    return CollectionModel.of(roles);
	}
	
	@GetMapping("/roles/{id}")
	@CrossOrigin(origins = "*")
	public EntityModel<Rol> findById(@PathVariable int id) {
		
		Rol rol= getRolService().findById(id).get();
		rol.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class).findById(rol.getId())).withSelfRel());
		return EntityModel.of(rol);
	}
	
	@GetMapping("/rolesPaginado")
	   @CrossOrigin(origins ="*")
	public PagedModel<EntityModel<Rol>> finAllPaginado(@RequestParam int size, 
			@RequestParam int page, @RequestParam String sort){
		StringTokenizer stringTokenizer = new StringTokenizer(sort, ",");
		Sort orden = Sort.by("a");
		String campo = stringTokenizer.nextToken();
		String tipoOrden = stringTokenizer.nextToken();
		
		if (tipoOrden.equals("asc")) {
			orden = Sort.by(campo).ascending();
		} else {
			orden = Sort.by(campo).descending();
		}
		
		Pageable pageable = PageRequest.of(page, size, orden);
		Page<Rol> rol = getRolService().findAll(pageable);
		
		return getPagedResourcesAssembler().toModel(rol, getRolModelAssembler());
	}
	
	@PostMapping("/roles")
	@CrossOrigin(origins = "*")
	public boolean save(@RequestBody Rol rol) {
		return existById(getRolService().save(rol).getId());
	}
	
	@DeleteMapping("/roles/{id}")
	@CrossOrigin(origins =  "*")
	public boolean deleteById(@PathVariable int id) {
		getRolService().deleteById(id);;
		return getRolService().existsById(id);
	}
	
	@PostMapping("/roles/{id}")
	@CrossOrigin(origins = "*")
	public boolean existById(@PathVariable int id) {
		return getRolService().existsById(id);
	}
	
	@GetMapping("roles/count")
	@CrossOrigin(origins = "*")
	public long getRolesCount(){
		return getRolService().count();
	}
}