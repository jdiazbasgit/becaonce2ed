package once.curso.proyectobanco.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import once.curso.proyectobanco.dtos.ProfileUserDto;
import once.curso.proyectobanco.entities.Profile;
import once.curso.proyectobanco.entities.User;

@Repository
public interface ProfileCRUDRepository extends PagingAndSortingRepository<Profile, Integer> {
	
	
	
	default ProfileUserDto getProfileUserDto(String user,String phone,String email) {
		
		ProfileUserDto profileUserDto = new ProfileUserDto();
		List<Profile> profiles =(List<Profile>) findAll();
		profileUserDto.setEmail(profiles.stream().filter(p-> p.getEmail().equals(email)).findFirst().isPresent());
		profileUserDto.setPhone(profiles.stream().filter(p-> p.getPhone().equals(phone)).findFirst().isPresent());
		profileUserDto.setUser(profiles.stream().filter(p-> p.getUser().getUser().equals(user)).findFirst().isPresent());
		
		return profileUserDto;
	}

	

	
}
