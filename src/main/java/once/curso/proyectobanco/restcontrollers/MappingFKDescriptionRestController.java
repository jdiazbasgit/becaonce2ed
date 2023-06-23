package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.MappingFKDescription;
import once.curso.proyectobanco.services.MappingFKDescriptionService;

@RestController
@Data
@RequestMapping("/once")
@CrossOrigin(origins = "*")
public class MappingFKDescriptionRestController {
	

	@Autowired
	private MappingFKDescriptionService mappingFKDescriptionService;
	
//	@GetMapping(value = "/fees/{id}")
//	public EntityModel<Fee> findById(@PathVariable Integer id) {
//		Fee fee=  getFeeService().findById(id).get();
//		fee.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MappingFKDescriptionRestController.class)
//				.findById(fee.getId())).withSelfRel());
//		 return EntityModel.of(fee);
//	}
	@GetMapping(value = "/showTables")
	public List<String> showTables() {
		try {
			return getMappingFKDescriptionService().showTables();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	@GetMapping(value = "/mappingFKDescriptions")
	public Iterable<MappingFKDescription> findAll() {
		return getMappingFKDescriptionService().findAll();
	}
	
	@GetMapping(value = "/getTables")
	public List<String> getTableNames() {
		return getMappingFKDescriptionService().getTableNames();
	}
	
//	@PatchMapping(value = "/fees")
//	public Iterable<Fee> findAllById(@RequestBody List<Integer> ids) {
//		return getFeeService().findAllById(ids);
//	}
//	
//	@PostMapping("/fees")
//	public boolean save(@RequestBody Fee fee) {		
//		return getFeeService().existsById(getFeeService().save(fee).getId());
//	}
//	
//	@PutMapping("/fees")
//	public List <Fee> saveAll(@RequestBody List<Fee> fees) {
//		return (List<Fee>) getFeeService().saveAll(fees);
//	}
//
//	@DeleteMapping("/fees/{id}")
//	public void deleteById(@PathVariable int id) {
//		getFeeService().deleteById(id);
//	}
//	
//	@PostMapping("/fees/{id}")
//	public boolean existsById(@PathVariable int id) {
//		return getFeeService().existsById(id);
//	}
}