package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.Data;
import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.entities.Profile;
import once.curso.proyectotienda.entities.SoldProduct;
import once.curso.proyectotienda.services.ExistingProductService;
import once.curso.proyectotienda.services.ProfileService;
import once.curso.proyectotienda.services.SoldProductService;

@SpringBootTest
@Data
public class SoldProductsTest {

	@Autowired
	private SoldProductService soldProductService;

	@Autowired
	private ExistingProductService existingProductService;

	@Autowired
	private ProfileService profileService;

	@Order(1)
	@Test
	public void testFindAll() {
		
		List<SoldProduct> soldProducts = (List<SoldProduct>) getSoldProductService().findAll();
		assertNotEquals(0, soldProducts.size()); // TestFindId
		
	}

	@Order(2)
	@Test
	public void testExistsById() {

		ExistingProduct existingProductRel = getExistingProductService().findById(100).get();
		Profile profileRel = getProfileService().findById(5).get();
		
		SoldProduct soldProductPrueba = new SoldProduct();
		soldProductPrueba.setQuantity(1);
		soldProductPrueba.setExistingProduct(existingProductRel);
		soldProductPrueba.setPrice(10);
//		soldProductPrueba.setPrice((int)(existingProductRel.getPrice()*soldProductPrueba.getQuantity()));
		soldProductPrueba.setDate(new Date());
		soldProductPrueba.setProfile(profileRel);
		soldProductPrueba.setBasket(true);
		
		getSoldProductService().save(soldProductPrueba);

		Integer numero = soldProductPrueba.getId();
		System.out.println("numero: "+numero);
		assertTrue(getSoldProductService().existsById(numero)); //TestExists
		
//		getSoldProductService().delete(soldProductPrueba);

	}

	@Order(3)
	@Test
	public void testSaveFindDeleteId() {
		
		Long contadorRegistro = getSoldProductService().count();

		ExistingProduct existingProductRel = getExistingProductService().findById(100).get();
		Profile profileRel = getProfileService().findById(5).get();
		
		SoldProduct soldProductNuevo = new SoldProduct();
		soldProductNuevo.setQuantity(2);
		soldProductNuevo.setExistingProduct(existingProductRel);
		soldProductNuevo.setPrice(10);
//		soldProductNuevo.setPrice((int)(existingProductRel.getPrice()*soldProductNuevo.getQuantity()));
		soldProductNuevo.setDate(new Date());
		soldProductNuevo.setProfile(profileRel);
		soldProductNuevo.setBasket(true);
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

		ExistingProduct existingProductRel = getExistingProductService().findById(100).get();
		Profile profileRel = getProfileService().findById(5).get();

		List<SoldProduct> soldProducts = new ArrayList<SoldProduct>();

		SoldProduct soldProductNuevo1 = new SoldProduct();
		soldProductNuevo1.setQuantity(3);
		soldProductNuevo1.setExistingProduct(existingProductRel);
		soldProductNuevo1.setPrice(10);
//		soldProductNuevo1.setPrice((int)(existingProductRel.getPrice()*soldProductNuevo1.getQuantity()));
		soldProductNuevo1.setDate(new Date());
		soldProductNuevo1.setProfile(profileRel);
		soldProductNuevo1.setBasket(true);

		soldProducts.add(soldProductNuevo1);
		contadorRegistro++;

		SoldProduct soldProductNuevo2 = new SoldProduct();
		soldProductNuevo2.setQuantity(4);
		soldProductNuevo2.setExistingProduct(existingProductRel);
		soldProductNuevo2.setPrice(10);
//		soldProductNuevo2.setPrice((int)(existingProductRel.getPrice()*soldProductNuevo2.getQuantity()));
		soldProductNuevo2.setDate(new Date());
		soldProductNuevo2.setProfile(profileRel);
		soldProductNuevo2.setBasket(true);

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
		
		getSoldProductService().deleteAllById(numeros);
		
		assertEquals(contadorRegistro, getSoldProductService().count()); //TestDeleteAll
		
	}


}
