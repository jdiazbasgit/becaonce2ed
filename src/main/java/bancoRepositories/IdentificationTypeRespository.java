package bancoRepositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bancoEntityes.IdentificationType;

@Repository
public interface IdentificationTypeRespository extends CrudRepository<IdentificationType, Integer> {


}
