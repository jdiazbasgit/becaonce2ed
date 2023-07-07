package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.Data;
import once.curso.proyectotienda.entities.SoldProduct;
import once.curso.proyectotienda.services.SoldProductService;

@SpringBootTest
@Data
public class SoldProductsTest {

	@Autowired
	private SoldProductService soldProductService;

	@Order(1)
	@Test
	public void testFindAll() {
		
		List<SoldProduct> soldProducts = (List<SoldProduct>) getSoldProductService().findAll();
		assertNotEquals(0, soldProducts.size()); // TestFindId
		
	}

	@Order(2)
	@Test
	public void testExistsById() {

		SoldProduct soldProductPrueba = new SoldProduct();
		soldProductPrueba.setQuantity(1);
		soldProductPrueba.setExistingProduct(soldProductPrueba.getExistingProduct());
		soldProductPrueba.setPrice(soldProductPrueba.getPrice()*soldProductPrueba.getQuantity());
		getSoldProductService().save(soldProductPrueba);

		Integer numero = soldProductPrueba.getId();
		System.out.println("numero: "+numero);
		assertTrue(getSoldProductService().existsById(numero)); //TestExists

	}

	@Order(3)
	@Test
	public void testSaveFindDeleteId() {
		
		Long contadorRegistro = getSoldProductService().count();

		SoldProduct soldProductNuevo = new SoldProduct();
		soldProductNuevo.setQuantity(2222);
		contadorRegistro++;

		getSoldProductService().save(soldProductNuevo);
		assertEquals(contadorRegistro, getSoldProductService().count()); //TestSave
		
		SoldProduct soldProductRecuperado = getSoldProductService().findById(soldProductNuevo.getId()).get();
		assertEquals(soldProductNuevo.getQuantity(), soldProductRecuperado.getQuantity()); //TestFind
		contadorRegistro--;

		getSoldProductService().delete(soldProductRecuperado);
		assertEquals(contadorRegistro, getSoldProductService().count()); //TestDelete

	}

	@Order(4)
	@Test
	public void testSaveFindDeleteAll() {
		
		Long contadorRegistro = getSoldProductService().count();

		List<SoldProduct> soldProducts = new ArrayList<SoldProduct>();

		SoldProduct soldProductNuevo1 = new SoldProduct();
		soldProductNuevo1.setQuantity(3333);
		soldProducts.add(soldProductNuevo1);
		contadorRegistro++;

		SoldProduct soldProductNuevo2 = new SoldProduct();
		soldProductNuevo2.setQuantity(4444);
		soldProducts.add(soldProductNuevo2);
		contadorRegistro++;

		getSoldProductService().saveAll(soldProducts);
		assertEquals(contadorRegistro, getSoldProductService().count()); //TestSaveAll
		
		List<Integer> numeros = new ArrayList<Integer>();
		
		numeros.add(soldProductNuevo1.getId());
		contadorRegistro--;
		
		numeros.add(soldProductNuevo2.getId());
		contadorRegistro--;

		List<SoldProduct> soldProductRecuperado = (List<SoldProduct>) getSoldProductService().findAllById(numeros);
		assertEquals(numeros.size(), soldProductRecuperado.size()); //TestFindAll
		contadorRegistro--;
		
		getSoldProductService().deleteAllById(numeros);
		
		assertEquals(contadorRegistro, getSoldProductService().count()); //TestDeleteAll
		
	}


}
