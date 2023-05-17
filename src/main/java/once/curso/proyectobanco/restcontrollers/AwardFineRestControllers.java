package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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
import once.curso.proyectobanco.entities.AwardsFine;
import once.curso.proyectobanco.entities.AwardsFinesType;
import once.curso.proyectobanco.services.AwardsFinesServices;

@RestController
@RequestMapping("/once")
@Data
public class AwardFineRestControllers {

	@Autowired
	private AwardsFinesServices awardFineServices;

	@GetMapping(value = "/awardFine/{id}")
	public EntityModel<AwardsFine> getAwardsFineById(@PathVariable int id) {
		AwardsFine awardsFine = getAwardFineServices().findById(id).get();

		awardsFine
				.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineRestControllers.class)
						.getAwardsFineById(awardsFine.getId())).withSelfRel());

		return EntityModel.of(awardsFine);
	}

	@GetMapping(value = "/awardFine")
	public CollectionModel<AwardsFine> findAll() {
		Iterable<AwardsFine> awardsFine = getAwardFineServices().findAll();
		awardsFine.forEach(c -> {
			c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineRestControllers.class)
					.getAwardsFineById(c.getId())).withSelfRel());
			
			c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardsFinesConfigurationRestControllers.class)
					.getAwardsFinesConfigurationById(c.getId())).withRel("awardsFinesConfiguration"));
			
			c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestControllers.class)
					.getAwardsFinesTypeById(c.getId())).withRel("awardsFinesType"));
		});
		
		return CollectionModel.of(awardsFine);
	}

	@PostMapping(value = "/awardFine")
	public AwardsFine save(@RequestBody AwardsFine awardFine) {
		return getAwardFineServices().save(awardFine);

	}

	@PutMapping(value = "/awardFine")
	public List<AwardsFine> saveAll(@RequestBody List<AwardsFine> awardFine) {
		return (List<AwardsFine>) getAwardFineServices().saveAll(awardFine);
	}

	
	@DeleteMapping(value = "/awardFine/{id}")
	public void deleteById(@PathVariable int id) {
		getAwardFineServices().deleteById(id);

	}
}
