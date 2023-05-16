package once.curso.proyectobanco;

<<<<<<< HEAD
=======
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
>>>>>>> feature/develop-banco
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
>>>>>>> feature/develop-banco
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

<<<<<<< HEAD
=======
import lombok.Data;
import once.curso.proyectobanco.entities.IdentificationType;
>>>>>>> feature/develop-banco
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
	
	    @Test
	    public void testSaveAll() {
	        List<Profile> profiles = new ArrayList<>();
	        Profile profile1 = new Profile();
	        profile1.setName("John");
	        profile1.setSecondName("Bogle");
	        profile1.setEmail("john.doe@example.com");
	        profile1.setIdentification("A458385933");
	        profile1.setPhone("658658658");
	        byte[] imagen1 = {1,2,3};
	        profile1.setImage(imagen1);
	        profiles.add(profile1);

	        Profile profile2 = new Profile();
	        profile2.setName("Jane");
	        profile2.setSecondName("Doe");
	        profile2.setEmail("jane.doe@example.com");
	        profile2.setIdentification("B258385933");
	        profile2.setPhone("555555555");
	        byte[] imagen2 = {4,5,6};
	        profile2.setImage(imagen2);
	        profiles.add(profile2);

	        Iterable<Profile> savedProfiles = profileService.saveAll(profiles);
	        assertEquals(profiles.size(), ((List<Profile>)savedProfiles).size());
	    } 

	    
	    @Test
	    public void testFindById() {
	        Optional<Profile> optionalProfile = profileService.findById(1);
	        assertTrue(optionalProfile.isPresent(), "El perfil debería existir en la base de datos");

	        Profile profile = optionalProfile.get();
	        assertEquals("John", profile.getName());
	        assertEquals("Bogle", profile.getSecondName());
	        assertEquals("john.doe@example.com1", profile.getEmail());
	        assertEquals("A458385933", profile.getIdentification());
	        assertEquals("658658658", profile.getPhone());
	        assertArrayEquals(new byte[] {1, 2, 3}, profile.getImage());
	    }

	    @Test
	    public void testFindByIdNotFound() {
	        Optional<Profile> optionalProfile = profileService.findById(-1);
	        assertFalse(optionalProfile.isPresent(), "El perfil no debería existir en la base de datos");
	    }
	    
	    @Test
	    public void testExistsById() {
	        Profile profile = new Profile();
	        profile.setName("John");
	        profile.setSecondName("Doe");
	        profile.setEmail("john.doe@example.com");
	        profile.setIdentification("A123456789");
	        profile.setPhone("555-1234");
	        byte[] image = {1, 2, 3};
	        profile.setImage(image);

	        Profile savedProfile = getProfileService().save(profile);
	        Integer id = savedProfile.getId();

	        assertTrue(profileService.existsById(id));

	        getProfileService().delete(savedProfile);
	        assertFalse(profileService.existsById(id));
	    }
	    
	    public void testFindAll() {
	        List<Profile> profiles = (List<Profile>) profileService.findAll();
	        assertNotEquals(profiles.size(),0); 
	    }
	    
	    @Test
	    public void testFindAllById() {
	        Profile profile1 = new Profile();
	        profile1.setName("John");
	        profile1.setSecondName("Doe");
	        profile1.setEmail("johndoe@example.com");
	        profile1.setIdentification("A12345678");
	        profile1.setPhone("123456789");
	        profile1.setImage(new byte[] { 1, 2, 3 });
	        
	        Profile profile2 = new Profile();
	        profile2.setName("Jane");
	        profile2.setSecondName("Doe");
	        profile2.setEmail("janedoe@example.com");
	        profile2.setIdentification("A87654321");
	        profile2.setPhone("987654321");
	        profile2.setImage(new byte[] { 4, 5, 6 });
	        
	        List<Profile> profiles = new ArrayList<>();
	        profiles.add(profile1);
	        profiles.add(profile2);
	        
	        getProfileService().saveAll(profiles);
	        
	        List<Integer> ids = Arrays.asList(profile1.getId(), profile2.getId());
	        
	        Iterable<Profile> result = profileService.findAllById(ids);
	        
	        assertTrue(result.iterator().hasNext());
	        
	        List<Profile> resultList = new ArrayList<>();
	        
	        result.forEach(resultList::add);
	        
	        assertEquals(2, resultList.size());
	        assertTrue(resultList.contains(profile1));
	        assertTrue(resultList.contains(profile2));
	        
	        getProfileService().deleteAll(profiles);
	    }
	    
	    @Test
	    public void testCount() {
	        List<Profile> profiles = new ArrayList<>();
	        for (int i = 0; i < 5; i++) {
	            Profile profile = new Profile();
	            profiles.add(profile);
	        }
	        profileService.saveAll(profiles);
	        assertEquals(5, profileService.count());
	    }
	    
	    @Test
	    public void testDeleteById() {
	        Profile profile = new Profile();
	        profile.setName("John");
	        profile.setSecondName("Doe");
	        profile.setEmail("john.doe@example.com");
	        Profile savedProfile = getProfileService().save(profile);

	        Optional<Profile> foundProfile = profileService.findById(savedProfile.getId());
	        assertTrue(foundProfile.isPresent());

	        profileService.deleteById(savedProfile.getId());

	        foundProfile = profileService.findById(savedProfile.getId());
	        assertFalse(foundProfile.isPresent());
	    }
	    
	    @Test
	    public void testDelete() {
	        User user = userService.findById(1).get();
	        IdentificationType identificationType = identificationTypeService.findById(1).get();

	        Profile profile = new Profile();
	        profile.setName("John");
	        profile.setSecondName("Doe");
	        profile.setEmail("john.doe@example.com");
	        profile.setIdentification("A123456789");
	        profile.setPhone("123456789");
	        byte[] imagen = {1,2,3};
	        profile.setImage(imagen);
	        profile.setUser(user);
	        profile.setIdentificationType(identificationType);
	        Profile savedProfile = profileService.save(profile);

	        Optional<Profile> retrievedProfile = profileService.findById(savedProfile.getId());
	        assertTrue(retrievedProfile.isPresent());

	        profileService.delete(savedProfile);

	        assertFalse(profileService.existsById(savedProfile.getId()));
	    }
	    @Test
	    public void testDeleteAllById() {
	        User user1 = userService.findById(1).orElse(null);
	        User user2 = userService.findById(2).orElse(null);

	        IdentificationType idType1 = identificationTypeService.findById(1).orElse(null);
	        IdentificationType idType2 = identificationTypeService.findById(2).orElse(null);

	        Profile profile1 = new Profile();
	        profile1.setName("Test1");
	        profile1.setIdentificationType(idType1);
	        profile1.setIdentification("12345678A");
	        profile1.setEmail("test1@test.com");
	        profile1.setPhone("123456789");
	        profile1.setUser(user1);

	        Profile profile2 = new Profile();
	        profile2.setName("Test2");
	        profile2.setIdentificationType(idType2);
	        profile2.setIdentification("12345678B");
	        profile2.setEmail("test2@test.com");
	        profile2.setPhone("987654321");
	        profile2.setUser(user2);

	        Profile savedProfile1 = profileService.save(profile1);
	        Profile savedProfile2 = profileService.save(profile2);

	        List<Integer> idsToDelete = new ArrayList<>();
	        idsToDelete.add(savedProfile1.getId());
	        idsToDelete.add(savedProfile2.getId());

	        profileService.deleteAllById(idsToDelete);

	        assertFalse(profileService.existsById(savedProfile1.getId()));
	        assertFalse(profileService.existsById(savedProfile2.getId()));
	    }
	    
	    @Test
	    void testDeleteAll() {
	        List<Profile> profiles = new ArrayList<>();
	        User user = getUserService().findById(3).get();
	        IdentificationType identificationType = getIdentificationTypeService().findById(1).get();
	        for (int i = 1; i <= 5; i++) {
	            Profile profile = new Profile();
	            profile.setName("John");
	            profile.setSecondName("Bogle");
	            profile.setEmail("john.doe@example.com" + i);
	            profile.setIdentification("A458385933");
	            profile.setPhone("658658658");
	            byte[] imagen = {1,2,3};
	            profile.setImage(imagen);
	            profile.setUser(user);
	            profile.setIdentificationType(identificationType);
	            profiles.add(profile);
	        }

	        Iterable<Profile> savedProfiles = profileService.saveAll(profiles);

	        profileService.deleteAll();

	        assertFalse(profileService.findAll().iterator().hasNext());
	    }
}

