package once.curso.proyectobanco.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectobanco.entities.Profile;
import once.curso.proyectobanco.services.ProfileService;

@RestController
@Data
@RequestMapping("/once")
public class ProfileRestController {

	@Autowired
	private ProfileService profileService;

@GetMapping(value = "/profiles/{id}")
	public Profile findById(@PathVariable Integer id) {
		return getProfileService().findById(id).get();
	}
	
	@GetMapping(value = "/profiles")
	public Iterable<Profile> findAll() {
		return getProfileService().findAll();
	}
	
	@PostMapping("/profiles")
	public Profile save(@RequestBody Profile profile) {
		return getProfileService().save(profile);
	}
	
	@PutMapping("/profiles")
	public List <Profile> saveAll(@RequestBody List<Profile> profiles) {
		return (List<Profile>) getProfileService().saveAll(profiles);
	}

	@DeleteMapping("/profiles/{id}")
	public void deleteById(@PathVariable int id) {
		getProfileService().deleteById(id);
	}	
}