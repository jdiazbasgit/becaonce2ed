package bancoRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bancoEntityes.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
