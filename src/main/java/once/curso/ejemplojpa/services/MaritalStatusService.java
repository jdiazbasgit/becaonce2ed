package once.curso.ejemplojpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.repositories.MaritalStatusesCRUDRepository;

@Service
@Data
public class MaritalStatusService {
	//tomar en cuenta el getDatosLaborales de donde proviene
	@Autowired
	private MaritalStatusesCRUDRepository maritalStatusesCRUDRepository;
	
	public Iterable<MaritalStatusService> getDatosLaborales(){
		return getMaritalStatusCRUDRepositeory().findAll();
	}

}
