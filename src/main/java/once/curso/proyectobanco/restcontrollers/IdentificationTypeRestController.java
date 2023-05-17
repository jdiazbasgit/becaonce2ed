package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Fee;
import once.curso.proyectobanco.entities.IdentificationType;
import once.curso.proyectobanco.services.IdentificationTypeService;

@RestController
@Data
@RequestMapping("/once")
public class IdentificationTypeRestController {

	@Autowired
	private IdentificationTypeService identificationTypeService;


	@GetMapping(value = "/identificationsTypes/{id}")
	public EntityModel<IdentificationType> findById(@PathVariable Integer id) {
		IdentificationType identificationType=  getIdentificationTypeService().findById(id).get();
		identificationType.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(IdentificationTypeRestController.class)
				.findById(identificationType.getId())).withSelfRel());
		 return EntityModel.of(identificationType);
	}
	
	@GetMapping(value = "/identificationsTypes")
	public CollectionModel<IdentificationType> findAll(){
		Iterable<IdentificationType> identificationsTypes= getIdentificationTypeService().findAll();
		identificationsTypes.forEach(i->{
			i.add(WebMvcLinkBuilder.
					linkTo(WebMvcLinkBuilder.methodOn(IdentificationTypeRestController.class).
							findById(i.getId())).withSelfRel());
		});
		 
		 return CollectionModel.of(identificationsTypes);
	}
	
	@PostMapping("/identificationsTypes")
	public IdentificationType save(@RequestBody IdentificationType identificationType) {
		return getIdentificationTypeService().save(identificationType);
	}
	
	@PutMapping("/identificationsTypes")
	public List <IdentificationType> saveAll(@RequestBody List<IdentificationType> identificationsTypes) {
		return (List<IdentificationType>) getIdentificationTypeService().saveAll(identificationsTypes);
	}

	@DeleteMapping("/identificationsTypes/{id}")
	public void deleteById(@PathVariable int id) {
		getIdentificationTypeService().deleteById(id);
	}	
}