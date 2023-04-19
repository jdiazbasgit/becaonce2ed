package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectobanco.entities.IdentificationType;
import once.curso.proyectobanco.entities.Profile;
import once.curso.proyectobanco.entities.User;
import once.curso.proyectobanco.services.IdentificationTypeService;
import once.curso.proyectobanco.services.ProfileService;
import once.curso.proyectobanco.services.UserService;

@Data
@SpringBootTest
public class ProfileTest {

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private IdentificationTypeService identificationTypeService;
	@Test
	public void testProfile() {
		User user = getUserService().findById(3).get();
		IdentificationType identificationType = getIdentificationTypeService().findById(1).get();
		Profile profile = new Profile();
		profile.setName("John");
		profile.setSecondName("Bogle");
		profile.setEmail("john.doe@example.com1");
		profile.setIdentification("A458385933");
		profile.setPhone("658658658");
		byte[] imagen = {1,2,3};
		profile.setImage(imagen);
		profile.setUser(user);
		profile.setIdentificationType(identificationType);
		Profile savedProfile = profileService.save(profile);
		profileService.deleteById(savedProfile.getId());

		assertFalse(getProfileService().existsById(savedProfile.getId()));
	}

}
