package once.curso.ejemplojpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Company;
import once.curso.ejemplojpa.repositories.CompanyCrudRepository;

@Service
@Data
public class CompanyService {
	
	@Autowired
	private CompanyCrudRepository companyCrudRepository;
	
	public Iterable<Company> getDatosLaborales(){
		return getCompanyCrudRepository().findAll();
	}
}
