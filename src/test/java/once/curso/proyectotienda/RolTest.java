package once.curso.proyectotienda;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.Data;
import once.curso.proyectotienda.entities.Rol;
import once.curso.proyectotienda.services.RolService;

@SpringBootTest
@Data
public class RolTest {

	@Autowired
	private RolService rolService;
	
	@Order(1)
	@Test
	public void findByIdTest() {

		String rolOld = "FindByIdTestRole";
		int idGiven;

		// Para encontrar el id del valor de rol, imprescindible debe existirlo en BBDD, para
		// Primero buscarlo, si no lo existe, se debe insertarlo

		Optional<Rol> rolFinded = rolService.findByRol(rolOld);
		if (rolFinded.isPresent()) {
			System.out.println("EL ROL YA EXISTE, su id: " + rolFinded.get().getId());
			idGiven = rolFinded.get().getId();
		} else {
			System.out.println("EL ROL NO EXISTE");
			Rol rol= new Rol();
			rol.setRol(rolOld);
			Rol rolSaved = getRolService().save(rol);
			System.out.println("EL ROL INSERTADO, su id: " + rolSaved.getId());
			idGiven = rolSaved.getId();
		}

		// Test findById
		
		Optional<Rol> rolOldFindById = rolService.findById(idGiven);
		assertEquals(rolOldFindById.get().getRol(), rolOld);
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
	public void findByRolTest() {

		String rolOld = "FindByRolTestRole";

		// Para encontrar el valor de rol, imprescindible debe existirlo en BBDD, para
		// Primero buscarlo, si no lo existe, se debe insertarlo

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
	}

	@Order(5)
	@Test
	public void saveTest() {
		
		String rolNew = "SaveTestRole";

		// Para grabar un nuevo valor de rol, imprescindible debe que no lo exista en BBDD, para
		// evitar los duplicados. Primero buscarlo, si lo existe, se debe borrarlo

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
