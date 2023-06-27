package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	public void findByIdTest() {

/*
		String soldProductOld = "FindByIdTestSoldProduct";
		int idGiven;

		// Para encontrar el ID de soldProduct (findById), imprescindible debe existirlo en BBDD,
		// lo primero es buscarlo, como encontrarlo (findBySoldProduct):
		//  - Si lo existe (isPresent = true), debe obtener el numero de id (getId --> idGiven).
		//  - Si no lo existe (isPresent = false), se debe insertarlo (save) y obtener id (getId --> idGiven).

		Optional<SoldProduct> soldProductFinded = soldProductService.findByExistingProduct(soldProductOld);
		if (soldProductFinded.isPresent()) {
			System.out.println("EL SOLD PRODUCT YA EXISTE, su id: " + soldProductFinded.get().getId());
			idGiven = soldProductFinded.get().getId();
		} else {
			System.out.println("EL SOLD PRODUCT NO EXISTE");
			SoldProduct soldProduct= new SoldProduct();
			soldProduct.setSoldProduct(soldProductOld);
			SoldProduct soldProductSaved = getSoldProductService().save(soldProduct);
			System.out.println("EL SOLD PRODUCT INSERTADO, su id: " + soldProductSaved.getId());
			idGiven = soldProductSaved.getId();
		}

		// Test findById
		
		Optional<SoldProduct> soldProductOldFindById = soldProductService.findById(idGiven);
		assertEquals(soldProductOldFindById.get().getSoldProduct(), soldProductOld);
*/

	}

	
	
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

	@Order(4)
	@Test
	public void findBySoldProductTest() {
/*
		String rolOld = "FindByRolTestRole";

		// Para encontrar el VALOR de rol (findByRol), imprescindible debe existirlo en BBDD,
		// lo primero es buscarlo, como encontrarlo (findByRol):
		//  - Si lo existe (isPresent = true), no hace nada, queda igual, pasa a test findByRol
		//  - Si no lo existe (isPresent = false), se debe insertarlo (save)
		// Sin necesidad la variable idGiven

		Optional<Rol> rolFinded = rolService.findByRol(rolOld);
		if (rolFinded.isPresent()) {
			System.out.println("EL ROL YA EXISTE, su id: " + rolFinded.get().getId());
		} else {
			System.out.println("EL ROL NO EXISTE");
			Rol rol= new Rol();
			rol.setRol(rolOld);
			Rol rolSaved = getRolService().save(rol);
			System.out.println("EL ROL INSERTADO, su id: " + rolSaved.getId());
		}

		// Test findByRol
		
		Optional<Rol> rolOldFindByRol = rolService.findByRol(rolOld);
		assertEquals(rolOldFindByRol.get().getRol(), rolOld);

*/

	}

	@Order(5)
	@Test
	public void saveTest() {
		
/*

 		String rolNew = "SaveTestRole";

		// Para grabar un NUEVO VALOR de rol (save), imprescindible no lo exista en BBDD,
		// es una forma de evitar el problema de los duplicados (Duplicate for key 'roles.ROL_UNIQUE'),
		// lo primero es buscarlo, como encontrarlo (findByRol):
		//  - Si lo existe (isPresent = true), se debe borrarlo (deleteById)

		Optional<Rol> rolFinded = rolService.findByRol(rolNew);
		if (rolFinded.isPresent()) {
			System.out.println("NUEVO ROL YA EXISTE, su id: " + rolFinded.get().getId());
			rolService.deleteById(rolFinded.get().getId());
			System.out.println("EL NUEVO ROL BORRADO OK");
		}

		// Test save

		Rol rol= new Rol();
		rol.setRol(rolNew);

		getRolService().save(rol);
	    assertTrue(getRolService().existsById(rol.getId()));		

*/

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
