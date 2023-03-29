package once.curso.ejemplojpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.PersonalInformation;
import once.curso.ejemplojpa.repositories.PersonalInformationCRUDRepository;

@Service
@Data
public class PersonalInformationService {
	
	@Autowired
	private PersonalInformationCRUDRepository personalInformationCRUDRepository;
	
	public Iterable<PersonalInformation> getDatosLaborales(){
		
		return getPersonalInformationCRUDRepository().findAll();
	}

}
