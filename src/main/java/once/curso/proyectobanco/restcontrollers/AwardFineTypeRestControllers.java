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
import once.curso.proyectobanco.entities.AwardsFinesType;
import once.curso.proyectobanco.services.AwardFineTypeServices;

@RestController
@RequestMapping("/once")
@Data
public class AwardFineTypeRestControllers {

	@Autowired
	private AwardFineTypeServices awardFineTypeServices;

	@GetMapping(value = "/awardsFinesTypes/{id}")
	public AwardsFinesType findById(@PathVariable Integer id) {
		return getAwardFineTypeServices().findById(id).get();
	}

	@GetMapping(value = "/awardsFinesTypes")
	public Iterable<AwardsFinesType> findAll(@PathVariable Integer id) {
		return getAwardFineTypeServices().findAll();
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
	public AwardsFinesType deleteById(@RequestBody AwardsFinesType awardFineType) {
		return getAwardFineTypeServices().save(awardFineType);
	}
}
