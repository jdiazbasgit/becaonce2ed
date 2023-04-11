package once.curso.company.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.company.entities.Company;
import once.curso.company.repositories.CompanyCRUDRepository;

@Service
@Data
public class CompanyService {

	@Autowired
	private CompanyCRUDRepository companyCRUDRepository;

	public <S extends Company> S save(S entity) {
		return getCompanyCRUDRepository().save(entity);
	}

	public <S extends Company> Iterable<S> saveAll(Iterable<S> entities) {
		return getCompanyCRUDRepository().saveAll(entities);
	}

	public Optional<Company> findById(Integer id) {
		return getCompanyCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getCompanyCRUDRepository().existsById(id);
	}

	public Iterable<Company> findAll() {
		return getCompanyCRUDRepository().findAll();
	}

	public Iterable<Company> findAllById(Iterable<Integer> ids) {
		return getCompanyCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getCompanyCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getCompanyCRUDRepository().deleteById(id);
	}

	public void delete(Company entity) {
		getCompanyCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getCompanyCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Company> entities) {
		getCompanyCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getCompanyCRUDRepository().deleteAll();
	}
}
