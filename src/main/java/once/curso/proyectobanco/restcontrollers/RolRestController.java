package once.curso.proyectobanco.restcontrollers;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Rol;
import once.curso.proyectobanco.models.RolModelAssembler;
import once.curso.proyectobanco.services.RolService;

@Data
@RestController
@RequestMapping("/once")
public class RolRestController {

	@Autowired
	private RolService rolService;
	@Autowired
	private RolModelAssembler rolModelAssembler;
	@Autowired
	private PagedResourcesAssembler<Rol> pagedResourcesAssembler;

	@GetMapping(value = "/roles/{id}")
	@CrossOrigin(origins = "*")
	public EntityModel<Rol> findById(@PathVariable int id) {
		Rol rol=  getRolService().findById(id).get();
		rol.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class)
				.findById(rol.getId())).withSelfRel());
		 return EntityModel.of(rol);
	}

	/*@GetMapping(value = "/roles")
	public CollectionModel<Rol> findAll() {
		 Iterable<Rol> roles= getRolService().findAll();
		 roles.forEach(r->{
			 r.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class)
					 .findById(r.getId())).withSelfRel());
		 });
		 return CollectionModel.of(roles);
	}*/
	@GetMapping (value="/roles")
	@CrossOrigin(origins = "*")
	public PagedModel<EntityModel<Rol>>findAll(@RequestParam(defaultValue = "0")int size, @RequestParam(defaultValue = "0") int page,
			@RequestParam(required = false) String sort){
		if (size==0) {
			size=(int) getRolService().count();
		}
		Sort orden =Sort.by ("id");
		if (sort != null) {
			orden =Sort.by(sort);
			StringTokenizer stringTokenizer= new StringTokenizer(sort, ",");
			String campo = stringTokenizer.nextToken();
			String tipoOrden = stringTokenizer.nextToken();
			if (tipoOrden.contentEquals("asc")) {
				orden= Sort.by(campo).ascending();
			}
			else {
				orden =Sort.by(campo).descending();
			}
		}
		Pageable pageable =PageRequest.of(page, size, orden);
		Page<Rol> rol= getRolService().findAll(pageable);
		return getPagedResourcesAssembler().toModel(rol,getRolModelAssembler());
	}

	@PostMapping(value = "/roles")
	@CrossOrigin(origins = "*")
	public boolean save(@RequestBody Rol rol) {
		return getRolService().existsById(getRolService().save(rol).getId());
	}
	@PutMapping(value="/roles")
	@CrossOrigin(origins = "*")
	public List<Rol> saveAll(@RequestBody List<Rol> rol){
		return (List<Rol>)getRolService().saveAll(rol);
	}
	@DeleteMapping(value="/roles/{id}")
	@CrossOrigin(origins = "*")
	public void deleteById(@PathVariable Integer id) {
		getRolService().deleteById(id);
	}
	@PostMapping(value="/roles/{id]")
	@CrossOrigin(origins="*")
	public boolean existById(@PathVariable int id) {
		return getRolService().existsById(id);
	}
}
