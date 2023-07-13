package once.curso.proyectotienda;

import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.repositories.CardTypeCRUDRepository;
import once.curso.proyectotienda.repositories.ExistingProductCRUDRepository;
import once.curso.proyectotienda.services.CardTypeService;

@SpringBootTest
@Data
@TestMethodOrder(value = OrderAnnotation.class)
public class EjemploSumaTest {
	
	@Autowired
	private ExistingProductCRUDRepository existingProductCRUDRepository;
/*
	@Test
	public void probarSuma() {
		double suma= 0;
//		suma = getExistingProductCRUDRepository().countExistingProductByCategory(568);
		System.out.println(suma);
		assertTrue(true);
		
	}
*/
}
