package once.curso.banco.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.banco.bancoentityes.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

	

}
