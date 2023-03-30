package once.curso.ejemplojpa.repositories;

import org.springframework.data.repository.CrudRepository;

import once.curso.ejemplojpa.entityes.Company;

public class CompanyRepository {


	public interface CompanyRepository extends CrudRepository<Company, Integer> {

	}
}
