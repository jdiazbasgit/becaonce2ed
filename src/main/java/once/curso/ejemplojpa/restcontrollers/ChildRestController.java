package once.curso.ejemplojpa.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
	public CollectionModel<Child> findAll(){
		Iterable<Child> children= getChildService().findAll();
		children.forEach(c->{
			c.add(WebMvcLinkBuilder.
					linkTo(WebMvcLinkBuilder.methodOn(ChildRestController.class).
							getChildrenById(c.getId())).withSelfRel());
		});
		 
		 return CollectionModel.of(children);
	}
	
	@GetMapping("/children/{id}")
	public EntityModel<Child> getChildrenById(@PathVariable int id) {
		 Child child=getChildService().findById(id).get();
		 
		 child.add(WebMvcLinkBuilder.
					linkTo(WebMvcLinkBuilder.methodOn(ChildRestController.class).
							getChildrenById(child.getId())).withSelfRel());
		 return EntityModel.of(child);
	}
	
	@DeleteMapping("/children/{id}")
	public void deleteById(@PathVariable int id) {
		getChildService().deleteById(id);
	}

}








