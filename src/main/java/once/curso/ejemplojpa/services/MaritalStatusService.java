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
	private MaritalStatusRepository maritalStatusService;
	
	public void dameMaritalStatuses() {
		
		Iterable<MaritalStatus> materialStatuses = getMaritalStatusService().findAll();
		for (MaritalStatus maritalStatus : materialStatuses) {
			System.out.println(maritalStatus.getDescription());
			
		}
	}

}
