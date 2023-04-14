package once.curso.proyectobanco.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.TypeAccount;
import once.curso.proyectobanco.services.TypeAccountService;

@RestController
@Data
@RequestMapping("/once")
public class TypeAccountRestController {
	
	@Autowired
	private TypeAccountService typeAccountService;
	
	@GetMapping (value="/TypeAccount/{id}")
	public TypeAccount findById(@PathVariable Integer id) {
		return getTypeAccountService().findById(id).get();
	}

}
