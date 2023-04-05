package bancoServices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bancoEntityes.AwardFine;
import bancoRepositories.AwardFineRepository;
import lombok.Data;

@Data
@Service
public class AwardFineService {
	
	@Autowired
	private AwardFineRepository awardFineRepository;
	
public void dameMulta() {
	Iterable<AwardFine> multa= getAwardFineRepository().findAll();
	for (AwardFine awardFine : multa) {
		System.out.println(awardFine.getAwardFineConfiguration());
		System.out.println(awardFine.getAwardFineType());
		System.out.println(awardFine.getTime());
		
	}
}
public long count() {
	return count();
}

public void delete(AwardFine entity) {
getAwardFineRepository().delete(entity);	
}

public void deleteAll() {
getAwardFineRepository().deleteAll();	
}

public void deleteAll(Iterable<? extends AwardFine> entities) {
getAwardFineRepository().deleteAll(entities);	
}

public void deleteAllById(Iterable<? extends Integer> ids) {
	getAwardFineRepository().deleteAllById(ids);
}

public void deleteById(Integer id) {
getAwardFineRepository().deleteById(id);	
}

public boolean existsById(Integer id) {
	return getAwardFineRepository().existsById(id);
}

public Iterable<AwardFine> findAll() {
	return getAwardFineRepository().findAll();
}

public Iterable<AwardFine> findAllById(Iterable<Integer> ids) {
	return getAwardFineRepository().findAllById(ids);
}

public Optional<AwardFine> findById(Integer id) {
	return getAwardFineRepository().findById(id);
}

public <S extends AwardFine> S save(S entity) {
	return getAwardFineRepository().save(entity);
}

public <S extends AwardFine> Iterable<S> saveAll(Iterable<S> entities) {
	return getAwardFineRepository().saveAll(entities);
}

}
