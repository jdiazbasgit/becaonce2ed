package once.curso.proyectobanco;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.Data;
import once.curso.proyectobanco.entities.TransactionsAwardsFine;
import once.curso.proyectobanco.services.TransactionsAwardsFineService;


@Data
@SpringBootTest
class TransactinsAwardsFineTests {

	@Autowired
	private TransactionsAwardsFineService transactionsAwardsFineService;
	
	
	@Test
	public void findAll() {
		List<TransactionsAwardsFine> transactionsAwardsFine =(List<TransactionsAwardsFine>) getTransactionsAwardsFineService().findAll();
		assertNotEquals(transactionsAwardsFine.size(), 0);
	
	}	
	


	

}
