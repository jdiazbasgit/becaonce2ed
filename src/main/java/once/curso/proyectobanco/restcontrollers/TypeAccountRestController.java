package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Transaction;
import once.curso.proyectobanco.entities.TypeAccount;
import once.curso.proyectobanco.services.TypeAccountService;

@RestController
@Data
@RequestMapping("/once")
public class TypeAccountRestController {

	@Autowired
	private TypeAccountService typeAccountService;

	@GetMapping(value = "/TypeAccount/{id}")
	public TypeAccount findById(@PathVariable Integer id) {
		return getTypeAccountService().findById(id).get();
	}

	@GetMapping(value = "/TypeAccount")
	public Iterable<TypeAccount> findAll(@PathVariable Integer id) {
		return getTypeAccountService().findAll();
	}
	@PostMapping (value="/TypeAccount")
	public TypeAccount save(@RequestBody TypeAccount typeAccount) {
		return getTypeAccountService().save(typeAccount);
	}
	@PostMapping (value ="/TypeAccount")
	public List<TypeAccount> saveAll(@RequestBody List<TypeAccount> typeAccount){
		return (List<TypeAccount>)getTypeAccountService().saveAll(typeAccount);
	}
	@DeleteMapping(value="typeAccount")
	public void deleteById(@PathVariable Integer id) {
		getTypeAccountService().deleteById(id);
	}
}
