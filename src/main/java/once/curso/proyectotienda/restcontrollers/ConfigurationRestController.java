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
import once.curso.proyectotienda.entities.Configuration;
import once.curso.proyectotienda.model.ConfigurationModelAssembler;
import once.curso.proyectotienda.services.ConfigurationService;

@Data
@RequestMapping("/once")
@RestController
public class ConfigurationRestController {

	@Autowired
	private ConfigurationService configurationService;

	@Autowired
	private PagedResourcesAssembler<Configuration> pagedResourcesAssembler;

	@Autowired
	private ConfigurationModelAssembler configurationModelAssembler;

	@GetMapping("/configurations")
	@CrossOrigin(origins = "*")
	public CollectionModel<Configuration> findAll() {
		Iterable<Configuration> configurations = getConfigurationService().findAll();
		configurations.forEach(c -> {
			c.add(WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder.methodOn(ConfigurationRestController.class).findById(c.getId()))
					.withSelfRel());
		});
		return CollectionModel.of(configurations);
	}

	@GetMapping(value = "configurations/{id}")
	@CrossOrigin(origins = "*")
	public EntityModel<Configuration> findById(@PathVariable int id) {
		Configuration configurations = getConfigurationService().findById(id).get();
		configurations.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ConfigurationRestController.class).findById(configurations.getId()))
				.withSelfRel());

		return EntityModel.of(configurations);
	}

	@GetMapping("/configurationsPaginado")
	@CrossOrigin(origins = "*")
	public PagedModel<EntityModel<Configuration>> findAllPaginado(@RequestParam int size, @RequestParam int page,
			@RequestParam String sort) {
		StringTokenizer stringTokenizer = new StringTokenizer(sort, ",");
		Sort orden = Sort.by("a");
		String campo = stringTokenizer.nextToken();
		String tipoOrden = stringTokenizer.nextToken();

		if (tipoOrden.equals("asc"))
			orden = Sort.by(campo).ascending();
		else
			orden = Sort.by(campo).descending();

		Pageable pageable = PageRequest.of(page, size, orden);
		Page<Configuration> configuration = getConfigurationService().findAll(pageable);

		return getPagedResourcesAssembler().toModel(configuration, getConfigurationModelAssembler());
	}

	@PostMapping("/Configurations/create")
	@CrossOrigin(origins = "*")
	public Configuration save(@RequestBody Configuration configuration) {
		return getConfigurationService().save(configuration);
	}

	@DeleteMapping("/configurations/{id}")
	@CrossOrigin(origins = "*")
	public void deleteById(@PathVariable int id) {
		getConfigurationService().deleteById(id);
	}
}