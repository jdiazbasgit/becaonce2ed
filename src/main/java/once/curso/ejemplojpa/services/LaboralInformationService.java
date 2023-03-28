package once.curso.ejemplojpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.LaboralInformation;
import once.curso.ejemplojpa.repositories.LaboralInformationCRUDRepository;

@Service	
@Data
public class LaboralInformationService {

	@Autowired
	private LaboralInformationCRUDRepository laboralInformationCRUDRepository;
	
	public Iterable<LaboralInformation> getDatosLaborales(){
		return getLaboralInformationCRUDRepository().findAll();
		
	}
}
