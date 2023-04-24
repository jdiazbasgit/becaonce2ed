package once.curso.proyectotienda.restcontrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.services.ProfileService;

@RestController
@Data
@RequestMapping({"/api/v1/"})
public class ProfileRestController {
	@Autowired
	private final ProfileService profileService;
	
	/* C CREATE A PROFILE */
	@PostMapping("/profiles/create")
	public Profile createProfile(@RequestBody Profile newProfile) {
		return getProfileService().save(newProfile);
	}
	
	/* R READ ALL PROFILE */
	@GetMapping("/profiles")
	public List<Profile> getProfile() {
	    return (List<Profile>) profileService.findAll();
	}
	
	/* R READ A PROFILE */
	@GetMapping("/profiles/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable(value = "id") int profileId)
        throws ResourceNotFoundException {
		Profile profile = getProfileService().findById(profileId)
          .orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado id :: " + profileId));
        return ResponseEntity.ok().body(profile);
    }
		
	/* U UPDATE A PROFILE */
	@PutMapping("/profiles/update/{id}") //FUNCIONA Junit text pero NO FUNCIONA SPRING BOOT APP 
	//@GetMapping("/profiles/update/{id}") //NO FUNCIONA Junit text pero FUNCIONA SPRING BOOT APP
	public ResponseEntity<Profile> updateProfile(@PathVariable(value = "id") int profileId, @RequestBody Profile profileDetails) 
			throws ResourceNotFoundException {
		Profile profile = getProfileService().findById(profileId)
	    	    .orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado id :: " + profileId));

		profile.setName(profileDetails.getName());
		profile.setSecond_name(profileDetails.getSecond_name());
		profile.setIdentification(profileDetails.getIdentification());
		profile.setCredit_card(profileDetails.getCredit_card());
		profile.setAddress(profileDetails.getAddress());
		profile.setPostal_code(profileDetails.getPostal_code());
		profile.setCountry(profileDetails.getCountry());
		profile.setEmail(profileDetails.getEmail());
		profile.setCity(profileDetails.getCity());
		profile.setPhone(profileDetails.getPhone());
		profile.setImage(profileDetails.getImage());
		profile.setUsers(profileDetails.getUsers());
		profile.setCardstypes(profileDetails.getCardstypes());
		profile.setDocumentstypes(profileDetails.getDocumentstypes());
	    final Profile updateProfile = getProfileService().save(profile);
	    return ResponseEntity.ok(updateProfile);
	}
		
	/* D DELETE A PROFILES */
	@DeleteMapping("/profiles/delete/{id}") //FUNCIONA Junit text pero NO FUNCIONA SPRING BOOT APP 
	//@GetMapping("/profiles/delete/{id}") //NO FUNCIONA Junit text pero FUNCIONA SPRING BOOT APP
	public Map<String, Boolean> deleteExistingProduct(@PathVariable(value = "id") int profileId) 
			throws ResourceNotFoundException {
		Profile profile = getProfileService().findById(profileId)
				.orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado id :: " + profileId));

		getProfileService().delete(profile);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	/* TOTAL PROFILES */
	@GetMapping("/profiles/count")
	public long getprofileCount() {
		return profileService.count();
    }
	
}
