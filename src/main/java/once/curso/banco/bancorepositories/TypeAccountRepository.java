package once.curso.banco.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.banco.bancoentityes.TypeAccount;

@Repository
public interface TypeAccountRepository extends CrudRepository<TypeAccount, Integer> {

	
}
