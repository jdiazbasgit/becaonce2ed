package once.curso.banco.bancorepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.banco.bancoentityes.IdentificationType;

@Repository
public interface IdentificationTypeRespository extends CrudRepository<IdentificationType, Integer> {


}
