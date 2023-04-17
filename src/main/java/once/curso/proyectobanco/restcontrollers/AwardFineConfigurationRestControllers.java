package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardFineConfiguration;
import once.curso.proyectobanco.services.AwardFineConfigurationServices;

@RestController
@RequestMapping
@Data
public class AwardFineConfigurationRestControllers {
	
	@Autowired
	private AwardFineConfigurationServices awardFineConfigurationServices;
	
	@GetMapping(value = "/awardFineConfiguration/id")
	public AwardFineConfiguration findById(@PathVariable Integer id) {
		return getAwardFineConfigurationServices().findById(id).get();
	}

	@GetMapping(value = "/awardFineConfiguration")
	public Iterable<AwardFineConfiguration> findAll(@PathVariable Integer id){
		return getAwardFineConfigurationServices().findAll();
	}
	
	@PostMapping(value = "/awardFineConfiguration")
	public AwardFineConfiguration save(@RequestBody AwardFineConfiguration awardFineConfiguration) {
		return getAwardFineConfigurationServices().save(awardFineConfiguration);
	}
	
	@PostMapping(value = "/awardFineConfiguration")
	public List<AwardFineConfiguration> saveAll(@RequestBody List<AwardFineConfiguration> awardFineConfigurations){
		return (List<AwardFineConfiguration>) getAwardFineConfigurationServices().findAll();
	}
	
	@DeleteMapping(value = "/awardFineConfiguration")
	public AwardFineConfiguration deleteById(@RequestBody AwardFineConfiguration awardFineConfiguration) {
		return getAwardFineConfigurationServices().save(awardFineConfiguration);
	}
}
