package once.curso.proyectobanco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.beans.CurrentAccountBean;
import once.curso.proyectobanco.entities.CurrentAccount;
import once.curso.proyectobanco.entities.Transaction;
@Repository
public interface TransactionCRUDRepository extends PagingAndSortingRepository<Transaction, Integer> {

	@Query ("from transaction as t where t.currentAccount.number =:numberCurrentAccount.number")
	public List<Transaction> getTransactionsByCurrentAccount(CurrentAccount numberCurrentAccount);
}
