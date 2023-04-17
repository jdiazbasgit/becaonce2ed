package once.curso.proyectotienda.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.services.ProfileService;

@RestController
@Data
public class ProfileRestController {
	@Autowired
	private final ProfileService profileService;
	

	@GetMapping("/profile")
	public List<Profile> getProfile() {
	    return (List<Profile>) profileService.findAll();
	}
}
