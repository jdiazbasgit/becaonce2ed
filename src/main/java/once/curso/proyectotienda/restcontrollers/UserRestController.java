package once.curso.proyectotienda.restcontrollers;

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
import once.curso.proyectotienda.entities.User;
import once.curso.proyectotienda.model.UserModelAssembler;
import once.curso.proyectotienda.services.UserService;

@RestController
@RequestMapping("/once")
@Data
public class UserRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private PagedResourcesAssembler<User> pagedResourcesAssembler;

	@Autowired
	private UserModelAssembler userModelAssembler;

	@GetMapping("/users")
	@CrossOrigin(origins = "*")
	public CollectionModel<User> dameUser() {
		Iterable<User> users = getUserService().findAll();
		users.forEach(u -> {
			u.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class).findById(u.getRol().getId()))
					.withRel("rol"));
			u.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).findById(u.getId()))
					.withSelfRel());
		});
		return CollectionModel.of(users);
	}

	@GetMapping("/users/{id}")
	@CrossOrigin(origins = "*")
	public EntityModel<User> findById(@PathVariable Integer id) {
		User user = getUserService().findById(id).get();
		user.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(RolRestController.class).findById(user.getRol().getId()))
				.withRel("rol"));
		user.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).findById(user.getId()))
				.withSelfRel());
		return EntityModel.of(user);
	}

	@GetMapping("/user")
	@CrossOrigin(origins = "*")
	public Iterable<User> findAll() {
		return getUserService().findAll();
	}

	@PutMapping("/users")
	@CrossOrigin(origins = "*")
	public List<User> saveAll(@RequestBody List<User> users) {
		return (List<User>) getUserService().saveAll(users);
	}

	@GetMapping("/usersPaginado")
	@CrossOrigin(origins = "*")
	public PagedModel<EntityModel<User>> findAllPaginado(@RequestParam int size, @RequestParam int page,
			@RequestParam String sort) {
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
		Page<User> user = getUserService().findAll(pageable);

		return getPagedResourcesAssembler().toModel(user, getUserModelAssembler());
	}

	@PostMapping("/users")
	@CrossOrigin(origins = "*")
	public boolean save(@RequestBody User user) {
		return existById(getUserService().save(user).getId());
	}

	@DeleteMapping("/user/{id}")
	@CrossOrigin(origins = "*")
	public boolean deleteById(@PathVariable int id) {
		getUserService().deleteById(id);
		return getUserService().existsById(id);
	}

	@PostMapping("users/{id}")
	@CrossOrigin(origins = "*")
	public boolean existById(@PathVariable int id) {
		return getUserService().existsById(id);
	}
}
