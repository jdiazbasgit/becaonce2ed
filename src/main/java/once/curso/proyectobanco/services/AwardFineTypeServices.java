package once.curso.proyectobanco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.AwardFineType;
import once.curso.proyectobanco.repositories.AwardFineTypeCRUDRepositories;

@Service
@Data
public class AwardFineTypeServices {
	
	@Autowired
	private AwardFineTypeCRUDRepositories awardFineTypeCRUDRepositories;
	
	public void dameAwardFineType() {
		
		Iterable<AwardFineType> awardsFinesTypes = getAwardFineTypeCRUDRepositories().findAll();
		for (AwardFineType awardFineType : awardsFinesTypes) {
			System.out.println(awardFineType.getDescription());
		}
	}
		
}
