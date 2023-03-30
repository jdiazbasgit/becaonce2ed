package once.curso.ejemplojpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.PersonalInformation;
import once.curso.ejemplojpa.repositories.PersonalInformationCRUDRepository;


@Service
@Data
public class PersonalInformationservice {
	
	@Autowired
	private PersonalInformationCRUDRepository personalInformationCRUDRepository;
	
	public void dameDatosPersonales() {
	
	Iterable<PersonalInformation> datosPersonales =
		 getPersonalInformationCRUDRepository().findAll();	
		for(PersonalInformation personalInformationCRUDRepository: datosPersonales) {	
 	System.out.println(personalInformationCRUDRepository.getChild());
	System.out.println(personalInformationCRUDRepository.getMaritalStatus());
	}
	
	}
	
	
	
	

}
