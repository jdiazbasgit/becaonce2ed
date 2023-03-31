package once.curso.ejemplojpa;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.ejemplojpa.entityes.Child;
import once.curso.ejemplojpa.services.ChildServices;

@SpringBootTest
@Data
class EjemploJpaApplicationTests {
	
	@Autowired
	private ChildServices hijoService;
	
	@Test
	public void findAll () {
		
		List<Child> children= (List<Child>) getHijoService().findAll();
		assertNotEquals(children.size(), 0);
		
	}


	

}

