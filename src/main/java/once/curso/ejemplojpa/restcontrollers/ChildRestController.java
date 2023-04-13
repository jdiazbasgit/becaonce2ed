package once.curso.ejemplojpa.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.services.ChildService;

@RestController
@RequestMapping("/once")
@Data
public class ChildRestController {
	
	@Autowired
	private ChildService childService;
	
	@PostMapping("/children")
	public Child save(@RequestBody  Child child) {
		return getChildService().save(child);
	}
	
	@GetMapping("/children")
	public Iterable<Child> findAll(){
		return getChildService().findAll();
	}
	
	@DeleteMapping("/children/{id}")
	public void deleteById(@PathVariable int id) {
		getChildService().deleteById(id);
	}

}








