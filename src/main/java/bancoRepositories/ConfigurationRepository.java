package bancoRepositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bancoEntityes.Configuration;

@Repository
public interface ConfigurationRepository extends CrudRepository<Configuration, Integer> {

	
}
