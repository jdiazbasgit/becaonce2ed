package once.curso.proyectobanco.restcontrollers;

import org.hibernate.EntityMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Configuration;
import once.curso.proyectobanco.entities.Description;
import once.curso.proyectobanco.services.ConfigurationService;
import once.curso.proyectobanco.services.DescriptionService;

@RestController
@Data
@RequestMapping("/once")
public class DescriptionRestController {
	@Autowired
	private DescriptionService descriptionService;
	
	@GetMapping(value =" /descriptions/{id}")
	public EntityModel<Description> findById(@PathVariable int id) {
		Description description= getDescriptionService().findById(id).get();
		description.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class)
				.findById(description.getId())).withSelfRel());
		 return EntityModel.of(description);
	}
	
	
	
	@GetMapping(value = "/descriptions")
	public CollectionModel<Description> findAll() {
		Iterable<Description> descriptions= getDescriptionService().findAll();
		descriptions.forEach(d->{
			  d.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DescriptionRestController.class)
					  .findById(d.getId())).withRel("description"));
		});
		 return CollectionModel.of(descriptions);
		 }
	@PostMapping(value = "/descriptions")
	public Description save(@RequestBody Description description) {
		return getDescriptionService().save(description);
	}
	@DeleteMapping(value="/description/{id}")
	public void deleteById(@PathVariable Integer id) {
		getDescriptionService().deleteById(id);
	}
	
}
