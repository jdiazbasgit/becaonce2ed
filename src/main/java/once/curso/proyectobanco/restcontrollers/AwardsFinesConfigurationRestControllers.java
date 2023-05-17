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
import once.curso.proyectobanco.services.AwardsFinesConfigurationServices;

@RestController
@RequestMapping
@Data
public class AwardsFinesConfigurationRestControllers {

	@Autowired
	private AwardsFinesConfigurationServices awardsFinesConfigurationServices;

	@GetMapping(value = "/awardsFinesConfiguration/{id}")
	public EntityModel<AwardsFinesConfiguration> getAwardsFinesConfigurationById(@PathVariable int id) {
		AwardsFinesConfiguration awardsFinesConfiguration = getAwardsFinesConfigurationServices().findById(id).get();

		awardsFinesConfiguration
				.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardsFinesConfigurationRestControllers.class)
						.getAwardsFinesConfigurationById(awardsFinesConfiguration.getId())).withSelfRel());

		return EntityModel.of(awardsFinesConfiguration);
	}

	@GetMapping(value = "/AwardsFinesConfiguration")
	public CollectionModel<AwardsFinesConfiguration> findAll() {
		Iterable<AwardsFinesConfiguration> awardsFinesConfiguration = getAwardsFinesConfigurationServices().findAll();
		awardsFinesConfiguration.forEach(c -> {
			c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AwardsFinesConfigurationRestControllers.class)
					.getAwardsFinesConfigurationById(c.getId())).withSelfRel());
		});

		return CollectionModel.of(awardsFinesConfiguration);
	};

	@PostMapping(value = "/AwardsFinesConfiguration")
	public AwardsFinesConfiguration save(@RequestBody AwardsFinesConfiguration AwardsFinesConfiguration) {
		return getAwardsFinesConfigurationServices().save(AwardsFinesConfiguration);
	}

	@PutMapping(value = "/AwardsFinesConfiguration")
	public List<AwardsFinesConfiguration> saveAll(
			@RequestBody List<AwardsFinesConfiguration> AwardsFinesConfigurations) {
		return (List<AwardsFinesConfiguration>) getAwardsFinesConfigurationServices().findAll();
	}

	@DeleteMapping(value = "/AwardsFinesConfiguration/{id}")
	public AwardsFinesConfiguration deleteById(@RequestBody AwardsFinesConfiguration AwardsFinesConfiguration) {
		return getAwardsFinesConfigurationServices().save(AwardsFinesConfiguration);
	}
}
