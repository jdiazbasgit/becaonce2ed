package once.curso.ejemplojpa.services;

import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Company;
import once.curso.ejemplojpa.repositories.CompanyRepository;

@Data
@Service

public class CompanyService {

	private CompanyRepository companyRepository;

	public void dameCompañias() {

		Iterable<Company> compañias = getCompanyRepository().findAll();
		for (Company company : compañias) {
			System.out.println(company.getDescription());
		}

	}

	public String[] dameCompañias(String filtro) {
		return getCompanyRepository().dameCompany(filtro);
	}
}
