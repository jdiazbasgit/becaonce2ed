package bancoRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bancoEntityes.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
