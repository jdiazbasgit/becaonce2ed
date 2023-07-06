package once.curso.proyectotienda.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.dtos.ProfileUserDto;
import once.curso.proyectotienda.entities.Profile;

@Repository
public interface ProfileCRUDRepository extends PagingAndSortingRepository<Profile, Integer> {
	default ProfileUserDto getProfileUserDto(String identification, String user,String phone,String email, String creditcard) {
		ProfileUserDto profileUserDto = new ProfileUserDto();
		List<Profile> profiles =(List<Profile>) findAll();
		
		profileUserDto.setIdentification(profiles.stream().filter(p-> 
		p.getIdentification().equals(identification)).findFirst().isPresent());
		
		profileUserDto.setCreditcard(profiles.stream().filter(p-> 
		p.getCreditCard().equals(creditcard)).findFirst().isPresent());
		
		profileUserDto.setEmail(profiles.stream().filter(p-> 
			p.getEmail().equals(email)).findFirst().isPresent());
		
		profileUserDto.setPhone(profiles.stream().filter(p-> 
			p.getPhone().equals(phone)).findFirst().isPresent());
		
		profileUserDto.setUser(profiles.stream().filter(p-> 
			p.getUser().getUser().equals(user)).findFirst().isPresent());
		
		return profileUserDto;
	}
}
