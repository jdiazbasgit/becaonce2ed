package once.curso.ejemplojpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Company;
import once.curso.ejemplojpa.repositories.CompanyRepository;

@Service
@Data
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public void dameEmpresas() {
		Iterable<Company> compañias= getCompanyRepository().findAll();
		for (Company company : compañias) {
			System.out.println(company.getCif());
			System.out.println(company.getDescription());
		}
	}

}
