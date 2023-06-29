package once.curso.proyectotienda;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.entities.CardType;
import once.curso.proyectotienda.repositories.CardTypeCRUDRepository;
import once.curso.proyectotienda.services.CardTypeService;

@SpringBootTest
@Data
@TestMethodOrder(value = OrderAnnotation.class)
 class CardTypeTest {

	@Autowired
	private CardTypeCRUDRepository cardTypeCRUDRepository;

	@Autowired
	private CardTypeService cardTypeService;

	@Test
	@Order(1)
	public void findAll() {
		List<CardType> cardType = (List<CardType>) getCardTypeService().findAll();
		assertNotEquals(cardType.size(), 0);
	}

	@Test
	@Order(2)
	public void probarSaveFindDelete() {
		CardType cardType = new CardType();
		cardType.setDescription("prueba AA");
		getCardTypeService().save(cardType);
		CardType cardTypeRecuperado = getCardTypeService().findById(cardType.getId()).get();
		getCardTypeService().delete(cardTypeRecuperado);

		assertFalse(getCardTypeService().existsById(cardType.getId()));

	}

	@Test
	@Order(3)
	public void probarSaveAllDeleteAllById() {
		Long cantidadAlEmpezar = getCardTypeService().count();
		List<CardType> cardTypes = new ArrayList<CardType>();
		CardType cardTypePrueba1 = new CardType();
		cardTypePrueba1.setDescription("prueba A");
		cardTypes.add(cardTypePrueba1);

		CardType cardTypePrueba2 = new CardType();
		cardTypePrueba2.setDescription("prueba B");
		cardTypes.add(cardTypePrueba2);

		getCardTypeService().saveAll(cardTypes);
		assertEquals(getCardTypeService().count(), cantidadAlEmpezar + 2);

		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(cardTypePrueba1.getId());
		numeros.add(cardTypePrueba2.getId());

		cardTypeService.deleteAllById(numeros);

		assertEquals(cantidadAlEmpezar, getCardTypeService().count());

	}

	@Test
	@Order(4)
	public void probarFindByIdAndDeleteById() {
		List<CardType> cardTypes = new ArrayList<CardType>();
		CardType cardTypePrueba1 = new CardType();
		cardTypePrueba1.setDescription("prueba A");
		cardTypes.add(cardTypePrueba1);
		cardTypeService.saveAll(cardTypes);

		Optional<CardType> resultado = cardTypeService.findById(cardTypePrueba1.getId());
		assertTrue(resultado.isPresent());
		assertTrue(resultado.get().getDescription().equals("prueba A"));

		cardTypeService.deleteById(cardTypePrueba1.getId());
		Optional<CardType> resultadoDespues = cardTypeService.findById(cardTypePrueba1.getId());
		assertFalse(resultadoDespues.isPresent());
	}

	@Test
	@Order(5)
	public void probarCount() {
		List<CardType> cardTypes = new ArrayList<CardType>();
		CardType cardTypePrueba1 = new CardType();
		CardType cardTypePrueba2 = new CardType();
		CardType cardTypePrueba3 = new CardType();
		cardTypePrueba1.setDescription("pruebaA");
		cardTypePrueba2.setDescription("pruebaB");
		cardTypePrueba3.setDescription("pruebaC");
		cardTypes.add(cardTypePrueba1);
		cardTypes.add(cardTypePrueba2);
		cardTypes.add(cardTypePrueba3);
		long cantidadAntes = cardTypeService.count();
		cardTypeService.saveAll(cardTypes);

		long cantidad = cardTypeService.count();
		assertEquals(cantidadAntes +3, cantidad);

		 cardTypeService.deleteAll(cardTypes);
	}

	@Test
	@Order(6)
	public void probarExistById() {
		CardType cardTypePrueba1 = new CardType();
		cardTypePrueba1.setDescription("prueba AA");
		cardTypeService.save(cardTypePrueba1);

		assertTrue(cardTypeService.existsById(cardTypePrueba1.getId()));

		cardTypeService.delete(cardTypePrueba1);
	}

	@Test
	@Order(7)
	public void probarFindAll() {
		int cantidadAntes=(int) getCardTypeService().count();
		List<CardType> cardTypes = new ArrayList<>();
		CardType cardType1 = new CardType();
		cardType1.setDescription("Prueba AA");
		cardTypes.add(cardType1);
		CardType cardType2 = new CardType();
		cardType2.setDescription("PruebaBB");
		cardTypes.add(cardType2);
		cardTypeService.saveAll(cardTypes);

		List<CardType> allCardTypes = (List<CardType>) cardTypeService.findAll();
		assertEquals(cantidadAntes +2, allCardTypes.size());
		assertTrue(allCardTypes.contains(cardType1));
		assertTrue(allCardTypes.contains(cardType2));

		cardTypeService.deleteAll(cardTypes);
	}

	@Test
	@Order(8)
	public void probarFindAllById() {
	    List<CardType> cardTypes = new ArrayList<CardType>();
	    CardType cardTypePrueba1 = new CardType();
	    CardType cardTypePrueba2 = new CardType();
	    CardType cardTypePrueba3 = new CardType();
	    cardTypePrueba1.setDescription("pruebaAA");
	    cardTypePrueba2.setDescription("pruebaBB");
	    cardTypePrueba3.setDescription("pruebaCC");
	    cardTypes.add(cardTypePrueba1);
	    cardTypes.add(cardTypePrueba2);
	    cardTypes.add(cardTypePrueba3);
	    cardTypeService.saveAll(cardTypes);

	    List<CardType> cardTypesById = new ArrayList<CardType>();
	    cardTypesById.add(cardTypeService.findById(cardTypePrueba1.getId()).orElse(null));
	    cardTypesById.add(cardTypeService.findById(cardTypePrueba2.getId()).orElse(null));
	    cardTypesById.add(cardTypeService.findById(cardTypePrueba3.getId()).orElse(null));

	    assertNotEquals(0, cardTypesById.size());
	   
	   
	     cardTypeService.deleteAll(cardTypes);
	}
	
	@Test
	@Order(9)
	public void probarSaveAndRestoreTableData() {
	    List<CardType> cardTypesAnteriores = (List<CardType>) cardTypeService.findAll();
	    
	    List<CardType> cardTypesNuevos = new ArrayList<CardType>();
	    CardType cardTypePrueba1 = new CardType();
	    cardTypePrueba1.setDescription("pruebaAA");
	    cardTypesNuevos.add(cardTypePrueba1);
	    cardTypeService.saveAll(cardTypesNuevos);
	    
	    cardTypeService.deleteAll(cardTypesNuevos);
	    
	    	    
	    List<CardType> cardTypesRestaurados = (List<CardType>) cardTypeService.findAll();
	    assertFalse(cardTypesRestaurados.isEmpty());
	    assertEquals(cardTypesAnteriores.size(), cardTypesRestaurados.size());
	}
	

	
}



















