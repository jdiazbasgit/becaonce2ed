package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public AwardsFinesConfiguration findById(@PathVariable Integer id) {
		return getAwardsFinesConfigurationServices().findById(id).get();
	}

	@GetMapping(value = "/AwardsFinesConfiguration")
	public Iterable<AwardsFinesConfiguration> findAll(@PathVariable Integer id){
		return getAwardsFinesConfigurationServices().findAll();
	}
	
	@PostMapping(value = "/AwardsFinesConfiguration")
	public AwardsFinesConfiguration save(@RequestBody AwardsFinesConfiguration AwardsFinesConfiguration) {
		return getAwardsFinesConfigurationServices().save(AwardsFinesConfiguration);
	}
	
	@PutMapping(value = "/AwardsFinesConfiguration")
	public List<AwardsFinesConfiguration> saveAll(@RequestBody List<AwardsFinesConfiguration> AwardsFinesConfigurations){
		return (List<AwardsFinesConfiguration>) getAwardsFinesConfigurationServices().findAll();
	}
	
	@DeleteMapping(value = "/AwardsFinesConfiguration/{id}")
	public AwardsFinesConfiguration deleteById(@RequestBody AwardsFinesConfiguration AwardsFinesConfiguration) {
		return getAwardsFinesConfigurationServices().save(AwardsFinesConfiguration);
	}
}
