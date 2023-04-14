package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardFine;
import once.curso.proyectobanco.services.AwardFineServices;

@RestController
@RequestMapping("/once")
@Data
public class AwardFineRestControllers {

	@Autowired
	private AwardFineServices awardFineServices;

	@PostMapping(value = "/awardFine")
	public AwardFine save(@RequestBody AwardFine awardFine) {
		return getAwardFineServices().save(awardFine);

	}

	@PostMapping(value = "/awardFine")
	public List<AwardFine> saveAll(@RequestBody List<AwardFine> awardFine) {
		return (list<AwardFine>)getAwardFineServices().saveAll(awardFine);
		
	}

	@GetMapping(value = "/awardFine")
		public AwardFine findById(@RequestBody AwardFine awardFine) {
			return getAwardFineServices().findById(awardFine);
			
	}
	
	@DeleteMapping(value = "/awardFine/id")
	public AwardFine deleteById(@RequestBody AwardFine awardFine) {
		return getAwardFineServices().save(awardFine);
		
	}
}
		

	



