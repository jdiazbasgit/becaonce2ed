package once.curso.proyectotienda.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

import lombok.Data;
import once.curso.proyectotienda.dtos.ProfileDto;
import once.curso.proyectotienda.dtos.ProfileUserDto;
import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.entities.User;
import once.curso.proyectotienda.repositories.CardTypeCRUDRepository;
import once.curso.proyectotienda.repositories.DocumentTypeCRUDRepository;
import once.curso.proyectotienda.repositories.ProfileCRUDRepository;
import once.curso.proyectotienda.repositories.RolCRUDRepository;
import once.curso.proyectotienda.repositories.UserCRUDRepository;

@Service
@Data
public class ProfileService {
	@Autowired
	private UserCRUDRepository userCRUDRepository;

	@Autowired
	private RolCRUDRepository rolCRUDRepository;

	@Autowired
	private CardTypeCRUDRepository cardTypeCRUDRepository;

	@Autowired
	private DocumentTypeCRUDRepository documentTypeCRUDRepository;
	
	@Autowired
	private ProfileCRUDRepository profilesCRUDRepository;
	
	public Profile save(Profile entity) {
		return getProfilesCRUDRepository().save(entity);
	}
	
	public Iterable<Profile> saveAll(Iterable<Profile> entities) {
		return getProfilesCRUDRepository().saveAll(entities);
	}
	
	public Optional<Profile> findById(Integer id) {
		return getProfilesCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getProfilesCRUDRepository().existsById(id);
	}

	public Iterable<Profile> findAll() {
		return getProfilesCRUDRepository().findAll();
	}
	
	public Page<Profile> findAll(Pageable pageable){
		return getProfilesCRUDRepository().findAll(pageable);
	}

	
	public Iterable<Profile> findAllById(Iterable<Integer> ids) {
		return getProfilesCRUDRepository().findAllById(ids);
	}
	
	public long count() {
		return getProfilesCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getProfilesCRUDRepository().deleteById(id);
	}

	public void delete(Profile entity) {
		getProfilesCRUDRepository().delete(entity);
	}
	
	public void deleteAll(Iterable<? extends Profile> entities) {
		getProfilesCRUDRepository().deleteAll(entities);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		for (Integer id : ids){getProfilesCRUDRepository().deleteById(id);}
	}

	public void deleteAll() {
		getProfilesCRUDRepository().deleteAll();
	}
	
	public ProfileUserDto getProfileUserDto(String identification, String user,String phone,String email, String creditcard) {
		return getProfilesCRUDRepository().getProfileUserDto(identification, user, phone, email, creditcard);
	}
	
	@Transactional //con spring solo esto, si otra programa tiene que poner try catch. Contola la transaccionabilidad
	public Profile crearProfile(ProfileDto profileDto  ) {
		Profile profileNew = new Profile();
		
		profileNew.setName(profileDto.getName());
		profileNew.setSecondName(profileDto.getSecondName());
		profileNew.setIdentification(profileDto.getIdentification());
		profileNew.setCreditCard(profileDto.getCreditCard());
		profileNew.setAddress(profileDto.getAddress());
		profileNew.setPostalCode(profileDto.getPostalCode());
		profileNew.setCountry(profileDto.getCountry());
		profileNew.setEmail(profileDto.getEmail());
		profileNew.setCity(profileDto.getCity());
		profileNew.setPhone(profileDto.getPhone());
		profileNew.setImage(profileDto.getImage());
		
		profileNew.setCardType((getCardTypeCRUDRepository().findById(profileDto.getCardType()).get()));
		profileNew.setDocumentType((getDocumentTypeCRUDRepository().findById(profileDto.getDocumentType()).get()));
					
		 User userNuevo = new User();
		    userNuevo.setUser(profileDto.getUser());
		    userNuevo.setEnabled(false);
		    userNuevo.setPassword(new BCryptPasswordEncoder(5).encode(profileDto.getPassword()));
		    userNuevo.setRol(getRolCRUDRepository().findById(26).get()); //25 ES ROLE_ADMIN 26 ES ROLE_USER*/

		    /* ROLLBACK */
		    profileNew.setUser(getUserCRUDRepository().save(userNuevo)); /* GRABA USER*/
		    Profile p = getProfilesCRUDRepository().save(profileNew); /* NO GRABA PROFILE*/

		    return p;
	}
}
