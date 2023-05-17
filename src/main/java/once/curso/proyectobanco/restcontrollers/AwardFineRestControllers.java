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
import once.curso.proyectobanco.entities.AwardFine;
import once.curso.proyectobanco.services.AwardsFinesServices;

@RestController
@RequestMapping("/once")
@Data
public class AwardFineRestControllers {

	@Autowired
	private AwardsFinesServices awardFineServices;

	@GetMapping(value = "/awardFines/{id}")
	public AwardFine findById(@PathVariable Integer id) {
		return getAwardFineServices().findById(id).get();

	}

	@GetMapping(value = "/awardFines")
	public Iterable<AwardFine> findAll(@PathVariable Integer id) {
		return getAwardFineServices().findAll();
	}

	@PostMapping(value = "/awardFines")
	public AwardFine save(@RequestBody AwardFine awardFine) {
		return getAwardFineServices().save(awardFine);

	}

	@PutMapping(value = "/awardFines")
	public List<AwardFine> saveAll(@RequestBody List<AwardFine> awardFine) {
		return (List<AwardFine>) getAwardFineServices().saveAll(awardFine);
	}

	@DeleteMapping(value = "/awardFine/{id}")
	public void deleteById(@PathVariable int id) {
		 getAwardFineServices().deleteById(id);

	}
}
