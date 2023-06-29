package once.curso.proyectobanco.services;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import once.curso.proyectobanco.dtos.ProfileDto;
import once.curso.proyectobanco.dtos.ProfileUserDto;
import once.curso.proyectobanco.entities.Profile;
import once.curso.proyectobanco.entities.User;
import once.curso.proyectobanco.repositories.IdentificationTypeCRUDRepository;
import once.curso.proyectobanco.repositories.ProfileCRUDRepository;
import once.curso.proyectobanco.repositories.RolCRUDRepository;
import once.curso.proyectobanco.repositories.UserCRUDRepository;

@Service
@Data
public class ProfileService {
	


	@Autowired
	private ProfileCRUDRepository profileCRUDRepository;

	@Autowired
	private UserCRUDRepository userCRUDRepository;

	@Autowired
	private RolCRUDRepository rolCRUDRepository;

	@Autowired
	private IdentificationTypeCRUDRepository identificationTypeCRUDRepository;

	public <S extends Profile> S save(S entity) {
		return getProfileCRUDRepository().save(entity);
	}

	public <S extends Profile> Iterable<S> saveAll(Iterable<S> entities) {
		return getProfileCRUDRepository().saveAll(entities);
	}

	public Optional<Profile> findById(Integer id) {
		return getProfileCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getProfileCRUDRepository().existsById(id);
	}

	public Iterable<Profile> findAll() {
		return getProfileCRUDRepository().findAll();
	}

	public Page<Profile> findAll(Pageable pageable) {
		return getProfileCRUDRepository().findAll(pageable);
	}

	public Iterable<Profile> findAllById(Iterable<Integer> ids) {
		return getProfileCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getProfileCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getProfileCRUDRepository().deleteById(id);
	}

	public void delete(Profile entity) {
		getProfileCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getProfileCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Profile> entities) {
		getProfileCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getProfileCRUDRepository().deleteAll();
	}
	
	public ProfileUserDto getProfileUserDto(String user,String phone,String email, String identification) {
		
		return getProfileCRUDRepository().getProfileUserDto(user, phone, email,identification);
		
	}
	


	@Transactional
	public Profile crearProfile(ProfileDto profileDto  ) {
			Profile profileNew = new Profile();
			profileNew.setName(profileDto.getName());
			profileNew.setSecondName(profileDto.getSecondName());
			profileNew.setIdentification(profileDto.getIdentification());
			profileNew.setEmail(profileDto.getEmail());
			profileNew.setPhone(profileDto.getPhone());
			profileNew.setImage(profileDto.getImage());
			profileNew.setIdentificationType((getIdentificationTypeCRUDRepository().findById(profileDto.getIdentificationType()).get()));
			 User userNuevo = new User();
			    userNuevo.setUser(profileDto.getUser());
			    userNuevo.setEnabled(false);
			    userNuevo.setPassword(new BCryptPasswordEncoder(5).encode(profileDto.getPassword()));
			    userNuevo.setRol(getRolCRUDRepository().findById(2).get());

			    profileNew.setUser(getUserCRUDRepository().save(userNuevo));
			    Profile p = getProfileCRUDRepository().save(profileNew);

			    return p;
					
		

	}



}
