package once.curso.ejemplojpa.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.services.ChildService;

@RestController
@Data
@RequestMapping("/once")
public class ChildrenRestController {

	@Autowired
	private ChildService childService;

	//@GetMapping("/children")
	@PostMapping("/children")
	public Iterable<Child> dameHijos() {
		return getChildService().findAll();
	}

	@GetMapping(value = "/children/{id}")
	public Child getChilds(@PathVariable int id) {
		if (getChildService().findById(id).isPresent())

			return getChildService().findById(id).get();

		return null;
	}

}
