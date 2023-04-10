package once.curso.proyectoBancojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectoBancojpa.entities.AwardFineConfiguration;


@Repository
public interface AwardFineConfigurationRepository extends CrudRepository<AwardFineConfiguration, Integer> {

}
