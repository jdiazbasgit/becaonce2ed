package bancoRepositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bancoEntityes.AwardFineType;

@Repository
public interface AwardFineTypeRepository extends CrudRepository<AwardFineType,Integer> {


}
