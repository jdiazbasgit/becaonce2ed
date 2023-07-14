package once.curso.proyectobanco.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.TransactionProgramer;

@Repository
public interface TransactionProgramerCRUDRepository extends PagingAndSortingRepository<TransactionProgramer, Integer>{

	@Query ("from TransactionProgramer as t where t.currentAccount.id=:id")
	List<TransactionProgramer> getTransactionsByCurrentAccount(int id);

	
}
