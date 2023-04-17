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
import once.curso.proyectobanco.entities.AwardFineType;
import once.curso.proyectobanco.services.AwardFineTypeServices;

@RestController
@RequestMapping("/once")
@Data
public class AwardFineTypeRestControllers {

	@Autowired
	private AwardFineTypeServices awardFineTypeServices;

	@GetMapping(value = "/awrdFineType/{id}")
	public AwardFineType findById(@PathVariable Integer id) {
		return getAwardFineTypeServices().findById(id).get();
	}

	@GetMapping(value = "/awrdFineType")
	public Iterable<AwardFineType> findAll(@PathVariable Integer id) {
		return getAwardFineTypeServices().findAll();
	}

	@PostMapping(value = "/awrdFineType")
	public AwardFineType save(@RequestBody AwardFineType awardFineType) {
		return getAwardFineTypeServices().save(awardFineType);
	}

	@PostMapping(value = "/awrdFineType")
	public List<AwardFineType> saveAll(@RequestBody List<AwardFineType> awardFineTypes) {
		return (List<AwardFineType>) getAwardFineTypeServices().saveAll(awardFineTypes);
	}

	@DeleteMapping(value = "/awrdFineType")
	public AwardFineType deleteById(@RequestBody AwardFineType awardFineType) {
		return getAwardFineTypeServices().save(awardFineType);
	}
}
