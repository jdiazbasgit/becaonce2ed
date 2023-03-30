package once.curso.ejemplojpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.PersonalInformation;
import once.curso.ejemplojpa.repositories.PersonalInformationRepository;

@Service
@Data
public class PersonalInformationService {
	
	@Autowired
	private PersonalInformationRepository personalInformationRepository;
	
	public void dameDatosPersonales()  {
	Iterable<PersonalInformation> datosPersonales= getPersonalInformationRepository().findAll();
	for (PersonalInformation personalInformation : datosPersonales) {
		System.out.println(personalInformation.getChildren());
		System.out.println(personalInformation.getMaritalStatus());
		
	}
	
	}

	
	}		

