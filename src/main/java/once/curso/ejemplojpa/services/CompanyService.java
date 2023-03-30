package once.curso.ejemplojpa.services;

import org.omg.CORBA.PUBLIC_MEMBER;
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
		
		Iterable<Company> companies = getCompanyRepository().findAll();
		for (Company company : companies) {
			System.out.println(company.getCif());
			System.out.println(company.getDescription());
		
		}
		
		public <S extends Company> S save(entity) {
			return getCompanyRepository().save(entity);
			
		}
		
		
	}

}
