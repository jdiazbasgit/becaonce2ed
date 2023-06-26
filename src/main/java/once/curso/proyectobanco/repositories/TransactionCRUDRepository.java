package once.curso.proyectobanco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.Transaction;
@Repository
public interface TransactionCRUDRepository extends PagingAndSortingRepository<Transaction, Integer> {

	@Query ("from CurrentAccount where number = numberCurrentAccount")
	public List<Transaction> getTransactionsByCurrentAccount(int numberCurrentAccount);
}
