package once.curso.proyectobanco.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import once.curso.proyectobanco.entities.AwardFineType;
import once.curso.proyectobanco.services.AwardFineTypeServices;

@RestController
@RequestMapping("/once")
public class AwardFineTypeRestControllers {

	@Autowired
	private AwardFineTypeServices awardFineTypeServices;

	@GetMapping(value = "/awardFineType")
		public AwardFineType findById(@PathVariable Integer id) {
		return getAwardFineTypeService().findById(id).get();
	}
}

