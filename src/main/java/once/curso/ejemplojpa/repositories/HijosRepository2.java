package once.curso.ejemplojpa.repositories;
import java.util.Optional;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import once.curso.ejemplojpa.entityes.Child;



@Repository
public interface HijosRepository2 extends CrudRepository<Child, Integer> {

	
}
