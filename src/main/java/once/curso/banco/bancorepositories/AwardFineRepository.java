package once.curso.banco.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.banco.bancoentityes.AwardFine;

@Repository
public interface AwardFineRepository extends CrudRepository<AwardFine, Integer> {

	
}
