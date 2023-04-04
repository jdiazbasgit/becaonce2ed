package bancoRepositories;

import org.springframework.data.repository.CrudRepository;

import bancoEntityes.CurrentAcount;

public interface CurrentAcountRepository extends CrudRepository<CurrentAcount, Integer> {

}
