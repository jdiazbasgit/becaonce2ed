package once.curso.ejemplojpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.MaritalStatus;
import once.curso.ejemplojpa.repositories.MaritalStatusRepository;

@Service
@Data
public class MaritalStatusService {
	
	@Autowired
	private MaritalStatusRepository maritalStatusRepository;
	
	public void dameEstadoCivil() {
		Iterable<MaritalStatus> estadoCivil= getMaritalStatusRepository().findAll();
		for (MaritalStatus maritalStatus : estadoCivil) {
		System.out.println(maritalStatus.getDescription());	
		}
	}

	

}
