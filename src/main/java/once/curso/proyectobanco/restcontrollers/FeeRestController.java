package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Fee;
import once.curso.proyectobanco.entities.Rol;
import once.curso.proyectobanco.services.FeeService;

@RestController
@Data
@RequestMapping("/once")
public class FeeRestController {

	@Autowired
	private FeeService feeService;
	
	@GetMapping(value = "/fees/{id}")
	public EntityModel<Fee> findById(@PathVariable Integer id) {
		Fee fee=  getFeeService().findById(id).get();
		fee.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FeeRestController.class)
				.findById(fee.getId())).withSelfRel());
		 return EntityModel.of(fee);
	}
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/fees")
	public CollectionModel<Fee> findAll(HttpServletResponse response){
		Iterable<Fee> fees= getFeeService().findAll();
		fees.forEach(f->{
			f.add(WebMvcLinkBuilder.
					linkTo(WebMvcLinkBuilder.methodOn(FeeRestController.class).
							findById(f.getId())).withSelfRel());
		});
		//response.setHeader("Access-Control-Allow-Origin", "*");
		 
		 return CollectionModel.of(fees);
	}
	
	@PatchMapping(value = "/fees")
	public Iterable<Fee> findAllById(@RequestBody List<Integer> ids) {
		return getFeeService().findAllById(ids);
	}
	
	@PostMapping("/fees")
	public Fee save(@RequestBody Fee fee) {
		return getFeeService().save(fee);
	}
	
	@PutMapping("/fees")
	public List <Fee> saveAll(@RequestBody List<Fee> fees) {
		return (List<Fee>) getFeeService().saveAll(fees);
	}

	@DeleteMapping("/fees/{id}")
	public void deleteById(@PathVariable int id) {
		getFeeService().deleteById(id);
	}	
}