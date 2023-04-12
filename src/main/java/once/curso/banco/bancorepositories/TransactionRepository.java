package once.curso.banco.bancorepositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.banco.bancoentityes.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	
}
