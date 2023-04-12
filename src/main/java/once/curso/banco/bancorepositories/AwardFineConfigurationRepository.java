package once.curso.banco.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.banco.bancoentityes.AwardFineConfiguration;

@Repository
public interface AwardFineConfigurationRepository extends CrudRepository<AwardFineConfiguration, Integer> {

	

}
