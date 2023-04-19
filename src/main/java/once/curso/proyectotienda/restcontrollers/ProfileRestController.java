package once.curso.proyectotienda.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.services.ProfileService;

@RestController
@Data
@RequestMapping({"/api/v3/"})
public class ProfileRestController {
	@Autowired
	private final ProfileService profileService;
	
	/* R READ ALL PROFILE */
	@GetMapping("/profiles")
	public List<Profile> getProfile() {
	    return (List<Profile>) profileService.findAll();
	}
	
	/* R READ A PROFILE */
	@GetMapping("/profiles/{id}")
	public Optional<Profile> getProfileById(@PathVariable int id) {
		Optional<Profile> p = profileService.findById(id);
		if (!p.isPresent()) {
				System.err.println("El perfil id " + id + " no existe.");
	            return Optional.empty();
	    }
		return getProfileService().findById(id);
	}
	
}
