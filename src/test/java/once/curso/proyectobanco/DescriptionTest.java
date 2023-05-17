package once.curso.proyectobanco;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import once.curso.proyectobanco.entities.Description;
import once.curso.proyectobanco.services.DescriptionService;


@SpringBootTest
public class DescriptionTest {
	
	@Autowired
	private DescriptionService descriptionService;
	
	@Test
	public void testDescription() {
    

	}
}
