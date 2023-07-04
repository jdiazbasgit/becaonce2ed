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
import once.curso.proyectobanco.entities.AwardFine;

import once.curso.proyectobanco.models.AwardFineModelAssembler;
import once.curso.proyectobanco.services.AwardFineService;

@RestController
@RequestMapping("/once")
@Data
@CrossOrigin(origins = "*")
public class AwardFineRestController {

	@Autowired
	private AwardFineModelAssembler awardsFineModelAssembler;

	@Autowired
	private PagedResourcesAssembler<AwardFine> pagedResourcesAssembler;

	@Autowired
	private AwardFineService awardFineServices;

	@GetMapping(value = "/awardsFines/{id}")
	@CrossOrigin(origins = "*")
	
	public EntityModel<AwardFine> findById(@PathVariable int id) {
		AwardFine awardsFine = getAwardFineServices().findById(id).get();

		awardsFine.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(AwardFineRestController.class).findById(awardsFine.getId()))
				.withSelfRel());
		
		awardsFine.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestController.class)
				.findById(awardsFine.getAwardFineType().getId())).withRel("awardFineType"));
		
		awardsFine.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineConfigurationRestController.class)
				.findById(awardsFine.getAwardFineConfiguration().getId())).withRel("awardFineConfiguration"));

		return EntityModel.of(awardsFine);
	}

	/*
	 * @GetMapping(value = "/awardFine") public CollectionModel<AwardsFine>
	 * findAll() { Iterable<AwardsFine> awardsFine =
	 * getAwardFineServices().findAll(); awardsFine.forEach(c -> {
	 * c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
	 * AwardFineRestControllers.class) .findById(c.getId())).withSelfRel());
	 * 
	 * c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
	 * AwardsFinesConfigurationRestControllers.class)
	 * .findById(c.getId())).withRel("awardsFinesConfiguration"));
	 * 
	 * c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
	 * AwardFineTypeRestControllers.class)
	 * .findById(c.getId())).withRel("awardsFinesType")); });
	 * 
	 * return CollectionModel.of(awardsFine); }
	 */

	@GetMapping(value = "/awardsFines")
	@CrossOrigin(origins = "*")

	public PagedModel<EntityModel<AwardFine>> findAll(@RequestParam(defaultValue = "0") int size,
			@RequestParam(defaultValue = "0") int page, @RequestParam(required = false) String sort) {
		if (size == 0) {
			size = (int) getAwardFineServices().count();
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
		Page<AwardFine> awardFine = getAwardFineServices().findAll(pageable);

		return getPagedResourcesAssembler().toModel(awardFine, getAwardsFineModelAssembler());
	}

	@PostMapping(value = "/awardsFines")
	@CrossOrigin(origins = "*")
	
	public boolean save(@RequestBody AwardFine awardFine) {
		return getAwardFineServices().existsById(getAwardFineServices().save(awardFine).getId());

	}

	@PutMapping(value = "/awardsFines")
	@CrossOrigin(origins = "*")
	
	public List<AwardFine> saveAll(@RequestBody List<AwardFine> awardFine) {
		return (List<AwardFine>) getAwardFineServices().saveAll(awardFine);
	}

	@DeleteMapping(value = "/awardsFines/{id}")

	public boolean deleteById(@PathVariable int id) {
		getAwardFineServices().deleteById(id);
		return getAwardFineServices().existsById(id);

	}
	
	@PostMapping("/awardsFines/{id}")
	public boolean existsById(@PathVariable int id) {
		return getAwardFineServices().existsById(id);
	}
}
