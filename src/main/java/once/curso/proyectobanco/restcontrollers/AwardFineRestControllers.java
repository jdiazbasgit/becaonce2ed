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
import once.curso.proyectobanco.entities.AwardsFine;
import once.curso.proyectobanco.models.AwardsFineModelAssembler;
import once.curso.proyectobanco.services.AwardsFinesServices;

@RestController
@RequestMapping("/once")
@Data
public class AwardFineRestControllers {

	@Autowired
	private AwardsFineModelAssembler awardsFineModelAssembler;

	@Autowired
	private PagedResourcesAssembler<AwardsFine> pagedResourcesAssembler;

	@Autowired
	private AwardsFinesServices awardFineServices;

	@GetMapping(value = "/awardFine/{id}")
	@CrossOrigin(origins = "*")
	
	public EntityModel<AwardsFine> findById(@PathVariable int id) {
		AwardsFine awardsFine = getAwardFineServices().findById(id).get();

		awardsFine.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(AwardFineRestControllers.class).findById(awardsFine.getId()))
				.withSelfRel());

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

	@GetMapping(value = "/awardFine")
	@CrossOrigin(origins = "*")

	public PagedModel<EntityModel<AwardsFine>> findAll(@RequestParam(defaultValue = "0") int size,
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
		Page<AwardsFine> awardFine = getAwardFineServices().findAll(pageable);

		return getPagedResourcesAssembler().toModel(awardFine, getAwardsFineModelAssembler());
	}

	@PostMapping(value = "/awardFine")
	@CrossOrigin(origins = "*")
	
	public AwardsFine save(@RequestBody AwardsFine awardFine) {
		return getAwardFineServices().save(awardFine);

	}

	@PutMapping(value = "/awardFine")
	@CrossOrigin(origins = "*")
	
	public List<AwardsFine> saveAll(@RequestBody List<AwardsFine> awardFine) {
		return (List<AwardsFine>) getAwardFineServices().saveAll(awardFine);
	}

	@DeleteMapping(value = "/awardFine/{id}")
	@CrossOrigin(origins = "*")

	public void deleteById(@PathVariable int id) {
		getAwardFineServices().deleteById(id);

	}
}
