package once.curso.proyectobanco.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
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

@GetMapping(value = "/fees/{id}")
	public Fee findById(@PathVariable Integer id) {
		return getFeeService().findById(id).get();
	}
	
	@GetMapping(value = "/fees")
	public Iterable<Fee> findAll() {
		return getFeeService().findAll();
	}
	
	@PostMapping("/fees")
	public Fee save(@RequestBody Fee fee) {
		return getFeeService().save(fee);
	}
	
	@PostMapping("/fees")
	public List <Fee> saveAll(@RequestBody List<Fee> fees) {
		return (List<Fee>) getFeeService().saveAll(fees);
	}

	@DeleteMapping("/fees/{id}")
	public void deleteById(@PathVariable int id) {
		getFeeService().deleteById(id);
	}	
}