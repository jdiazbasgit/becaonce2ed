package once.curso.proyectobanco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import once.curso.proyectobanco.entities.CurrentAccount;

public interface CurrentAccountCRUDRepository extends PagingAndSortingRepository<CurrentAccount, Integer> {
	@Query("from CurrentAccount as ca where ca.user.user=:userName")
	public List<CurrentAccount> getCurrentAccountsByUser(String userName);
	
}
