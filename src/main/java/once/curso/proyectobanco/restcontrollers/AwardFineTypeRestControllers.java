package once.curso.proyectobanco.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value = "/awrdFineType/id")
	public AwardFineType findById(@PathVariable Integer id) {
		return getAwardFineTypeService().findById(id).get();
	}

}

