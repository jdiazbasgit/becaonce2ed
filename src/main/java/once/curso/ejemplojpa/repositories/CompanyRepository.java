package once.curso.ejemplojpa.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.ejemplojpa.entityes.Company;


@Repository
public interface CompanyRepository  extends CrudRepository<Company, Integer>{



}
