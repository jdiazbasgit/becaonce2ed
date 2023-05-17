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
import once.curso.proyectobanco.entities.AwardsFinesConfiguration;
import once.curso.proyectobanco.entities.AwardsFinesType;
import once.curso.proyectobanco.services.AwardsFinesTypeServices;

@RestController
@RequestMapping("/once")
@Data
public class AwardFineTypeRestControllers {

	@Autowired
	private AwardsFinesTypeServices awardFineTypeServices;

	@GetMapping(value = "/awardsFinesTypes/{id}")
	public EntityModel<AwardsFinesType> getAwardsFinesTypeById(@PathVariable int id) {
		AwardsFinesType awardsFinesType = getAwardFineTypeServices().findById(id).get();

			awardsFinesType
					.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestControllers.class)
							.getAwardsFinesTypeById(awardsFinesType.getId())).withSelfRel());
		
		return EntityModel.of(awardsFinesType);
	}

	@GetMapping(value = "/awardsFinesTypes")
	public CollectionModel<AwardsFinesType> findAll() {
		Iterable<AwardsFinesType> awardsFinesType = getAwardFineTypeServices().findAll();
		awardsFinesType.forEach(c -> {
			c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardFineTypeRestControllers.class)
					.getAwardsFinesTypeById(c.getId())).withSelfRel());
		});
		
		return CollectionModel.of(awardsFinesType);
	}

	@PostMapping(value = "/awardsFinesTypes")
	public AwardsFinesType save(@RequestBody AwardsFinesType awardFineType) {
		return getAwardFineTypeServices().save(awardFineType);
	}

	@PutMapping(value = "/awardsFinesTypes")
	public List<AwardsFinesType> saveAll(@RequestBody List<AwardsFinesType> awardFineTypes) {
		return (List<AwardsFinesType>) getAwardFineTypeServices().saveAll(awardFineTypes);
	}

	@DeleteMapping(value = "/awrdFineType")
	public void deleteById(@PathVariable int id) {
		 getAwardFineTypeServices().deleteById(id);
	}
}
