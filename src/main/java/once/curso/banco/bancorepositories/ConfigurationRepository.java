package once.curso.banco.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.banco.bancoentityes.Configuration;

@Repository
public interface ConfigurationRepository extends CrudRepository<Configuration, Integer> {

	
}
