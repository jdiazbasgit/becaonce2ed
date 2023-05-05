package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.services.ProfileService;

import once.curso.proyectotienda.services.UserService;

@SpringBootTest
@Data
public class ProfileTests {
	private String filename = "homer.jpg";
	@Autowired
	private ProfileService ProfileService;
	
	@Test
	public void Profile() {
		List<Profile> profile = (List<Profile>) getProfileService().findAll();
		assertNotEquals(profile.size(),0);
	}
	
	@Test
	public void findByIdProfile() {
		int numID = 3;
		getProfileService().findById(numID).get();
	}
	
	@Test
	public void AddProfile() {
		Profile profile = new Profile();
		profile.setName("David");
		profile.setSecond_name("Lira");
		profile.setIdentification("51234567L");
		profile.setCredit_card("4024007197782433");
		profile.setAddress("Calle Illescas, 110");
		profile.setPostal_code("28047");
		profile.setCountry("Madrid");
		profile.setEmail("homer@gmail.com");
		profile.setCity("Madrid");
		profile.setPhone("917182877");
		File file = new File(filename);
        byte[] imgInBytes = new byte[(int) file.length()];		
        profile.setImage(imgInBytes);
		/*profile.setUsers(getUserService().findById(1).get());
		profile.setCardstypes(getCardsTypeService().findById(1).get());
		profile.setDocumentstypes(getDocumentTypeService().findById(1).get());*/
	
		getProfileService().save(profile);
		
		Profile savedProfile = getProfileService().findById(profile.getId()).get();
		assertEquals(profile.getId(), savedProfile.getId());
	}
	
	@Test
	public void UpdProfile() {
		int numID = 1;
		
		Optional<Profile> p = getProfileService().findById(numID);
		if (p.isPresent()) {
			Profile profile = p.get();
			profile.setName("Sandra");
			profile.setSecond_name("Lira");
			profile.setIdentification("513334567L");
			profile.setCredit_card("4024333197782433");
			profile.setAddress("Calle Illescas, 114");
			profile.setPostal_code("28047");
			profile.setCountry("Madrid");
			profile.setEmail("homer@gmail.com");
			profile.setCity("Madrid");
			profile.setPhone("917182877");
			File file = new File(filename);
	        byte[] imgInBytes = new byte[(int) file.length()];		
	        profile.setImage(imgInBytes);
	        /*profile.setUsers(getUserService().findById(1).get());
			profile.setCardstypes(getCardsTypeService().findById(1).get());
			profile.setDocumentstypes(getDocumentTypeService().findById(1).get());*/
		    
		    getProfileService().save(profile);
		}
	}
	
	@Test
	public void DelByIdExistingProduct() {
		/* 
		 * NO TOQUEIS
		 
		 int numID = 1;
		Profile profile = getProfileService().findById(numID).orElse(null);
	    if (profile != null) {
	    	getProfileService().delete(profile);
	    }*/
	}
	
	@Test
	public void DelAllByIdExistingProduct() {
		/*
		NO TOQUEIS
		List<Profile> profile = (List<Profile>) getProfileService().findAll();
		List<Integer> idsToDelete =new ArrayList<>();
		idsToDelete.add(profile.get(3).getId());
		idsToDelete.add(profile.get(4).getId());
		
		getProfileService().deleteAllById(idsToDelete);*/
	}
	
	public void delProfile(ExistingProduct entity) {
		//getProfileCRUDRepository().delete(entity);
	}
	
	@Test
	public void CountExistingProduct() {
		getProfileService().count();
	}
	
	@Test
	public void DelAllentitiesProfile() {
		/*
		NO TOQUEIS
		
		List<Profile> existingProduct = (List<Profile>) getProfileService().findAll();
		List<Profile> objectToDelete =new ArrayList<Profile>();
		objectToDelete.add(profile.get(3));
		objectToDelete.add(profile.get(4));
		
		getProfileService().deleteAll(objectToDelete);*/
	}
	
	@Test
	public void DelAllProfile() {
		/*
		 NO TOQUEIS
		 
		 getProfileService().deleteAll();
        assertEquals(0, getProfileService().count());*/
	}
}
