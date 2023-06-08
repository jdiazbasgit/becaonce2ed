package once.curso.proyectobanco.restcontrollers;

import java.util.List;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.User;
import once.curso.proyectobanco.models.UserModelAssember;
import once.curso.proyectobanco.services.UserService;


@Data
@RestController
@RequestMapping("/once")
public class UserRestController {
	
	@Autowired
	private UserModelAssember userModelAssember;
	
	@Autowired
	private PagedResourcesAssembler<User> pagedResourcesAssembler; 
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/users")
	
	public PagedModel<EntityModel<User>> findAll (@RequestParam (defaultValue = "0")int size, @RequestParam (defaultValue = "0")int page,
			@RequestParam (required = false)String sort){
		if(size==0) {
			size=(int) getUserService().count();
		}
		
		Sort orden=Sort.by("id");
		if (sort != null) {
			orden=Sort.by(sort);		
			StringTokenizer stringTokenizer= new StringTokenizer(sort,",");
			
			
			String campo=stringTokenizer.nextToken();
			String tipoOrden=stringTokenizer.nextToken();
			
			if(tipoOrden.equals("asc"))
				orden=Sort.by(campo).ascending();
			else
				orden=Sort.by(campo).descending();
		}
		
		Pageable pageable =PageRequest.of(page, size,orden);
		Page<User> user =getUserService().findAll(pageable);
		
		return getPagedResourcesAssembler().toModel(user,getUserModelAssember());
	}
		
	@CrossOrigin(origins = "*")	
	@GetMapping("/users/{id}")
	public EntityModel<User> findById(@PathVariable Integer id) {
	User user= getUserService().findById(id).get();
	 user.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class)
			  .findById(user.getId())).withSelfRel());
	return EntityModel.of(user);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/users")
	public User save(@RequestBody User user){
		return getUserService().save(user);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/users")
	public List<User> saveAll(@RequestBody List<User> users){
		return (List<User>) getUserService().saveAll(users);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable int id) {
		 getUserService().deleteById(id);
	}
	
}
