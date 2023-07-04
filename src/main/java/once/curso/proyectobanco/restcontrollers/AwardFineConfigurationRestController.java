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
import once.curso.proyectobanco.entities.AwardFineConfiguration;
import once.curso.proyectobanco.models.AwardFineConfigurationModelAssembler;
import once.curso.proyectobanco.services.AwardFineConfigurationService;

@RestController
@RequestMapping("/once")
@Data
@CrossOrigin(origins = "*")
public class AwardFineConfigurationRestController {

	@Autowired
	private AwardFineConfigurationModelAssembler awardsFinesConfigurationModelAssembler;

	@Autowired
	private PagedResourcesAssembler<AwardFineConfiguration> PagedResourcesAssembler;

	@Autowired
	private AwardFineConfigurationService awardsFinesConfigurationServices;

	@GetMapping(value = "/awardsFinesConfigurations/{id}")
	@CrossOrigin(origins = "*")

	public EntityModel<AwardFineConfiguration> findById(@PathVariable int id) {
		AwardFineConfiguration awardsFinesConfiguration = getAwardsFinesConfigurationServices().findById(id).get();

		awardsFinesConfiguration
				.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineConfigurationRestController.class)
						.findById(awardsFinesConfiguration.getId())).withSelfRel());

		return EntityModel.of(awardsFinesConfiguration);
	}

	@GetMapping(value = "/awardsFinesConfigurations")
	@CrossOrigin(origins = "*")

	public PagedModel<EntityModel<AwardFineConfiguration>> findAll(@RequestParam(defaultValue = "0") int size,
			@RequestParam(defaultValue = "0") int page, @RequestParam(required = false) String sort) {
		if (size == 0) {
			size = (int) getAwardsFinesConfigurationServices().count();
		}

		Sort orden = Sort.by("id");
		if (sort != null) {
			orden = Sort.by(sort);
			StringTokenizer stringTokenizer = new StringTokenizer(sort, ",");

			String campo = stringTokenizer.nextToken();
			String tipoOrden = stringTokenizer.nextToken();

			if (tipoOrden.equals("asc"))
				orden = Sort.by(campo).ascending();
			else
				orden = Sort.by(campo).descending();

		}
		Pageable pageable = PageRequest.of(page, size, orden);
		Page<AwardFineConfiguration> awardsFinesConfiguration = getAwardsFinesConfigurationServices()
				.findAll(pageable);

		return getPagedResourcesAssembler().toModel(awardsFinesConfiguration,
				getAwardsFinesConfigurationModelAssembler());
	}

	@PostMapping(value = "/awardsFinesConfigurations")
	@CrossOrigin(origins = "*")

	public boolean save(@RequestBody AwardFineConfiguration AwardsFinesConfiguration) {
		return getAwardsFinesConfigurationServices().existsById(getAwardsFinesConfigurationServices().save(AwardsFinesConfiguration).getId());
	}

	@PutMapping(value = "/awardsFinesConfigurations")
	@CrossOrigin(origins = "*")

	public List<AwardFineConfiguration> saveAll(
			@RequestBody List<AwardFineConfiguration> AwardsFinesConfigurations) {
		return (List<AwardFineConfiguration>) getAwardsFinesConfigurationServices().findAll();
	}

	@DeleteMapping(value = "/awardsFinesConfigurations/{id}")
	@CrossOrigin(origins = "*")

	public boolean deleteById(@PathVariable int id) {
		getAwardsFinesConfigurationServices().deleteById(id);
		return getAwardsFinesConfigurationServices().existsById(id);
	}
	
	@PostMapping("/awardsFinesConfigurations/{id}")
	public boolean existsById(@PathVariable int id) {
		return getAwardsFinesConfigurationServices().existsById(id);
	}
}
