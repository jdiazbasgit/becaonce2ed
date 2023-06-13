package once.curso.proyectotienda;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.services.RolService;

@SpringBootTest
@Data
public class RolTest {

	@Autowired
	private RolService rolService;

	@Order(2)
	@Test
	public void findAllTest() {

		// Test findAll

	}

	@Order(3)
	@Test
	public void findAllByIdTest() {

		// Test findAllById

	}

	
	@Order(6)
	@Test
	public void saveAllTest() {
		
		// Test saveAll

	}

	@Order(7)
	@Test
	public void existsByIdTest() {
		
		// Test existsById

	}

	@Order(8)
	@Test
	public void countTest() {
		
		// Test count

	}

	@Order(9)
	@Test
	public void deleteByIdTest() {
		
		// Test deleteById

	}

	@Order(10)
	@Test
	public void deleteTest() {
		
		// Test delete

	}

	@Order(11)
	@Test
	public void deleteAllByIdTest() {
		
		// Test deleteAllById

	}

	@Order(12)
	@Test
	public void deleteAllIterableTest() {
		
		// Test deleteAllIterable

	}

	@Order(13)
	@Test
	public void deleteAllTest() {
		
		// Test deleteAll

	}

}
