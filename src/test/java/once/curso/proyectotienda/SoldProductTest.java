package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.entities.SoldProduct;
import once.curso.proyectotienda.services.SoldProductService;

@Data
@SpringBootTest
public class SoldProductTest {

	@Autowired
	private SoldProductService soldProductService;

	@Test
	public void findAll() {

		List<SoldProduct> soldProduct = (List<SoldProduct>) getSoldProductService().findAll();
		assertNotEquals(soldProduct.size(), 0);
	}

	public void probarFindDelete() {

		SoldProduct soldProduct = new SoldProduct();
		soldProduct.setExistingProduct(null);
		getSoldProductService().save(soldProduct);
		SoldProduct soldProductRecuperado = getSoldProductService().findById(soldProduct.getId()).get();
		getSoldProductService().delete(soldProductRecuperado);

		assertFalse(getSoldProductService().existsById(soldProduct.getId()));
	}
}
