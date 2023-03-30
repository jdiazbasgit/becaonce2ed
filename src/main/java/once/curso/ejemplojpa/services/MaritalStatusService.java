package once.curso.ejemplojpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.MaritalStatus;
import once.curso.ejemplojpa.repositories.MaritalStatusCRUDRepository;

@Service
@Data
public class MaritalStatusService {
	
	@Autowired
	private MaritalStatusCRUDRepository maritalStatusCRUDRepository;
	
	public Iterable<MaritalStatus> getDatosLaborales(){
		
		return getMaritalStatusCRUDRepository().findAll();
	}

}
