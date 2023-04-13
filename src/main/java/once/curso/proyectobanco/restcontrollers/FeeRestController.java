package once.curso.proyectobanco.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Data;
import once.curso.proyectobanco.entities.Fee;
import once.curso.proyectobanco.services.FeeService;

@RestController
@Data
@RequestMapping("/once")
public class FeeRestController {
	
	@Autowired
	private FeeService feeService;
	
	@GetMapping(value = "/fee/{id}")
	public Fee findById(@PathVariable Integer id) {
		return getFeeService().findById(id).get();
	}
	

}
