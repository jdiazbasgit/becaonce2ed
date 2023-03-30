package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Company;
import once.curso.ejemplojpa.repositories.CompanyRepository;

@Data
@Service

public class CompanyService {

	private CompanyRepository companyRepository;

	public void dameCompanies() {

		Iterable<Company> companies = getCompanyRepository().findAll();
		for (Company company : companies) {
			System.out.println(company.getDescription());
		}

	}

	public String[] dameCompañias(String filtro) {
		return getCompanyRepository().dameCompany(filtro);
	}

	public <S extends Company> S save(S entity) {
		return companyRepository.save(entity);
	}

	public <S extends Company> Iterable<S> saveAll(Iterable<S> entities) {
		return getCompanyRepository().saveAll(entities);
	}

	public Optional<Company> findById(Integer id) {
		return getCompanyRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getCompanyRepository().existsById(id);
	}

	public Iterable<Company> findAll() {
		return getCompanyRepository().findAll();
	}

	public Iterable<Company> findAllById(Iterable<Integer> ids) {
		return getCompanyRepository().findAllById(ids);
	}

	public long count() {
		return getCompanyRepository().count();
	}

	public void deleteById(Integer id) {
return ;
	}

	public void delete(Company entity) {

	}

	public void deleteAllById(Iterable<? extends Integer> ids) {

	}

	public void deleteAll(Iterable<? extends Company> entities) {

	}

	public void deleteAll() {

	}

}
