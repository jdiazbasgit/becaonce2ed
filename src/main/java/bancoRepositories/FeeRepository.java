package bancoRepositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import bancoEntityes.Fee;

public interface FeeRepository extends CrudRepository<Fee,Integer> {

	
}
