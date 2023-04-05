package bancoRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bancoEntityes.TypeAccount;

@Repository
public interface TypeAccountRepository extends CrudRepository<TypeAccount, Integer> {

}
