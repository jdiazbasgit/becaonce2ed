package bancoRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bancoEntityes.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {

	

}
