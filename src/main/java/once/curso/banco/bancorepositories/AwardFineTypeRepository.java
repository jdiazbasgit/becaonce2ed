package once.curso.banco.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.banco.bancoentityes.AwardFineType;

@Repository
public interface AwardFineTypeRepository extends CrudRepository<AwardFineType,Integer> {


}
