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
import once.curso.proyectobanco.entities.Profile;
import once.curso.proyectobanco.entities.User;
import once.curso.proyectobanco.services.ProfileService;

@RestController
@Data
@RequestMapping("/once")
public class ProfileRestController {

	@Autowired
	private ProfileService profileService;

	@GetMapping("/profiles/{id}")
	public EntityModel<Profile> findById(@PathVariable Integer id) {
	Profile profile= getProfileService().findById(id).get();
	profile.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class)
			  .findById(profile.getId())).withSelfRel());
	return EntityModel.of(profile);
	}
	
	@GetMapping("/profiles")	
	public CollectionModel<Profile> findAll(){
		  Iterable<Profile> profiles= getProfileService().findAll();
		  profiles.forEach(p->{
			  p.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(IdentificationTypeRestController.class)
					  .findById(p.getIdentificationType().getId())).withRel("identificationType"));
			  p.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestControllers.class)
					  .findById(p.getUser().getId())).withRel("user"));
			  p.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProfileRestController.class)
					  .findById(p.getId())).withSelfRel());
		  });
		  return CollectionModel.of(profiles);
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