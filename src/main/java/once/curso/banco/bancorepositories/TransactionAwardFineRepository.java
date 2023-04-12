package once.curso.banco.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.banco.bancoentityes.TransactionAwardFine;

@Repository
public interface TransactionAwardFineRepository extends CrudRepository<TransactionAwardFine, Integer> {

	
}
