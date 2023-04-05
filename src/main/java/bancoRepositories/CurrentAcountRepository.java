package bancoRepositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import bancoEntityes.CurrentAcount;

public interface CurrentAcountRepository extends CrudRepository<CurrentAcount, Integer> {


}
