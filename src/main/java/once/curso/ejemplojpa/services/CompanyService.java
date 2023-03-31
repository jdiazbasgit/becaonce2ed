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
	
	public void dameCompany() {
		Iterable<Company> datosCompany=getCompanyRepository().findAll();
		for (Company company : datosCompany) {
			System.out.println(company.getId());
			System.out.println(company.getDescription());
		}
	}

	public <S extends Company> S save(S entity) {
		return getCompanyRepository().save(entity);
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
		getCompanyRepository().deleteById(id);
	}

	public void delete(Company entity) {
		getCompanyRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getCompanyRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Company> entities) {
		getCompanyRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getCompanyRepository().deleteAll();
	}
}
