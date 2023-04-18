package once.curso.proyectobanco;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.Data;
import once.curso.proyectobanco.entities.Profile;
import once.curso.proyectobanco.services.ProfileService;

@DataJpaTest
public class ProfileTest {
	
	@Autowired
	private ProfileService profileService;
	
	@Test
	public void testProfile() {
		 Profile profile = new Profile();
	        profile.setName("John Doe");
	        profile.setEmail("john.doe@example.com");

	        Profile savedProfile = profileService.save(profile);
	        assertNotNull(savedProfile);

	        profileService.deleteById(savedProfile.getId());

	        Optional<Profile> deletedProfile = profileService.findById(savedProfile.getId());
	        assertFalse(deletedProfile.isPresent());
	}

}
