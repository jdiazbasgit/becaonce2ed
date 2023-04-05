package bancoRepositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bancoEntityes.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

	

}
