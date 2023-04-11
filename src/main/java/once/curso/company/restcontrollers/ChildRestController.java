package once.curso.company.restcontrollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.company.entities.Child;
import once.curso.company.services.ChildService;

@RestController
@Data
@RequestMapping("/once")
public class ChildRestController {

	@Autowired
	private ChildService childService;

	@GetMapping(value = "/childrenId/{id}")
	public Optional<Child> findById(@PathVariable Integer id) {
		if (!getChildService().findById(id).isPresent()) {
			
		}
		return Optional.of(getChildService().findById(id).get());
	}

}