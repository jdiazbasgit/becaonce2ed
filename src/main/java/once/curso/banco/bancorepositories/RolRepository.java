package once.curso.banco.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.banco.bancoentityes.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {

	

}
