package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Company;
import once.curso.ejemplojpa.repositories.CompanyCRUDRepository;

@Service
@Data
public class CompanyService {

	@Autowired
	private CompanyCRUDRepository companyCrudRepository;

	public <S extends Company> S save(S entity) {

		return getCompanyCrudRepository().save(entity);
	}

	public <S extends Company> Iterable<S> saveAll(Iterable<S> entities) {

		return getCompanyCrudRepository().saveAll(entities);
	}

	public Optional<Company> findById(Integer id) {

		return getCompanyCrudRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getCompanyCrudRepository().existsById(id);
	}

	public Iterable<Company> findAll() {

		return getCompanyCrudRepository().findAll();
	}

	public Iterable<Company> findAllById(Iterable<Integer> ids) {

		return getCompanyCrudRepository().findAllById(ids);
	}

	public long count() {

		return getCompanyCrudRepository().count();
	}

	public void deleteById(Integer id) {
		getCompanyCrudRepository().deleteById(id);
	}

	public void delete(Company entity) {
		getCompanyCrudRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getCompanyCrudRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Company> entities) {
		getCompanyCrudRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getCompanyCrudRepository().deleteAll();
	}
}
