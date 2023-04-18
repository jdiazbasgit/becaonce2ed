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
import once.curso.proyectobanco.services.AwardFineConfigurationServices;

@RestController
@RequestMapping
@Data
public class AwardFineConfigurationRestControllers {
	
	@Autowired
	private AwardFineConfigurationServices awardFineConfigurationServices;
	
	@GetMapping(value = "/awardFineConfigurations/id")
	public AwardsFinesConfiguration findById(@PathVariable Integer id) {
		return getAwardFineConfigurationServices().findById(id).get();
	}

	@GetMapping(value = "/awardFineConfigurations")
	public Iterable<AwardsFinesConfiguration> findAll(@PathVariable Integer id){
		return getAwardFineConfigurationServices().findAll();
	}
	
	@PostMapping(value = "/awardFineConfigurations")
	public AwardsFinesConfiguration save(@RequestBody AwardsFinesConfiguration awardFineConfiguration) {
		return getAwardFineConfigurationServices().save(awardFineConfiguration);
	}
	
	@PutMapping(value = "/awardFineConfigurations")
	public List<AwardsFinesConfiguration> saveAll(@RequestBody List<AwardsFinesConfiguration> awardFineConfigurations){
		return (List<AwardsFinesConfiguration>) getAwardFineConfigurationServices().saveAll(awardFineConfigurations);
	}
	
	@DeleteMapping(value = "/awardFineConfigurations")
	public AwardsFinesConfiguration deleteById(@RequestBody AwardsFinesConfiguration awardFineConfiguration) {
		return getAwardFineConfigurationServices().save(awardFineConfiguration);
	}
}
