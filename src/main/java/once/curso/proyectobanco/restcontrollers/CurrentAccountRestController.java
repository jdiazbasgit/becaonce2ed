package once.curso.proyectobanco.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.CurrentAccount;
import once.curso.proyectobanco.services.CurrentAccountService;

@RestController
@Data
@RequestMapping("/once")
public class CurrentAccountRestController {
	@Autowired
	private CurrentAccountService currentAccountService;
	
	@GetMapping(value =" /currentAccounts/{id}")
	public CurrentAccount findById(@PathVariable Integer id) {
		return getCurrentAccountService().findById(id).get();
	}
	@GetMapping(value = "/currentAccounts")
	public Iterable<CurrentAccount> CurrentAccountService(@PathVariable Integer id) {
		return getCurrentAccountService().findAll();
	}
	@PostMapping(value = "/currentAccounts")
	public CurrentAccount save(@RequestBody CurrentAccount currentAccount) {
		return getCurrentAccountService().save(currentAccount);
	}
	@DeleteMapping(value="/currentAccounts")
	public void deleteById(@PathVariable Integer id) {
		getCurrentAccountService().deleteById(id);
	}
	
}
