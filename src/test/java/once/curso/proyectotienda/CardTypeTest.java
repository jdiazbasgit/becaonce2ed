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
public class CardTypeTest {

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
		cardType.setDescription("pruebac");
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
		cardTypePrueba1.setDescription("pruebaA");
		cardTypes.add(cardTypePrueba1);

		CardType cardTypePrueba2 = new CardType();
		cardTypePrueba2.setDescription("pruebaB");
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
		cardTypePrueba1.setDescription("pruebaA");
		cardTypes.add(cardTypePrueba1);
		cardTypeService.saveAll(cardTypes);

		Optional<CardType> resultado = cardTypeService.findById(cardTypePrueba1.getId());
		assertTrue(resultado.isPresent());
		assertTrue(resultado.get().getDescription().equals("pruebaA"));

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
		cardTypeService.saveAll(cardTypes);

		long cantidad = cardTypeService.count();
		assertEquals(4, cantidad);

		cardTypes.forEach(cardType -> cardTypeService.deleteById(cardType.getId()));
	}

	@Test
	@Order(6)
	public void probarExistById() {
		List<CardType> cardTypes = new ArrayList<CardType>();
		CardType cardTypePrueba1 = new CardType();
		cardTypePrueba1.setDescription("pruebaA");
		cardTypes.add(cardTypePrueba1);
		cardTypeService.saveAll(cardTypes);

		assertTrue(cardTypeService.existsById(cardTypePrueba1.getId()));

		cardTypeService.delete(cardTypePrueba1);
	}

	@Test
	@Order(7)
	public void probarFindAll() {
		List<CardType> cardTypes = new ArrayList<>();
		CardType cardType1 = new CardType();
		cardType1.setDescription("PruebaA");
		cardTypes.add(cardType1);
		CardType cardType2 = new CardType();
		cardType2.setDescription("PruebaB");
		cardTypes.add(cardType2);
		cardTypeService.saveAll(cardTypes);

		List<CardType> allCardTypes = (List<CardType>) cardTypeService.findAll();
		assertEquals(3, allCardTypes.size());
		assertTrue(allCardTypes.contains(cardType1));
		assertTrue(allCardTypes.contains(cardType2));

		cardTypes.forEach(cardType -> cardTypeService.deleteById(cardType.getId()));
	}

	@Test
	@Order(8)
	public void probarFindAllById() {
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
	    cardTypeService.saveAll(cardTypes);

	    List<CardType> cardTypesById = new ArrayList<CardType>();
	    cardTypesById.add(cardTypeService.findById(cardTypePrueba1.getId()).orElse(null));
	    cardTypesById.add(cardTypeService.findById(cardTypePrueba2.getId()).orElse(null));
	    cardTypesById.add(cardTypeService.findById(cardTypePrueba3.getId()).orElse(null));

	    assertEquals(3, cardTypesById.size());
	    assertEquals(cardTypePrueba1.getDescription(), cardTypesById.get(0).getDescription());
	    assertEquals(cardTypePrueba2.getDescription(), cardTypesById.get(1).getDescription());
	    assertEquals(cardTypePrueba3.getDescription(), cardTypesById.get(2).getDescription());
	   
	    cardTypes.forEach(cardType -> cardTypeService.deleteById(cardType.getId()));
	}
	
	@Test
	@Order(9)
	public void probarSaveAndRestoreTableData() {
	    List<CardType> cardTypesAnteriores = (List<CardType>) cardTypeService.findAll();
	    
	    List<CardType> cardTypesNuevos = new ArrayList<CardType>();
	    CardType cardTypePrueba1 = new CardType();
	    cardTypePrueba1.setDescription("pruebaA");
	    cardTypesNuevos.add(cardTypePrueba1);
	    cardTypeService.saveAll(cardTypesNuevos);
	    
	    cardTypeService.deleteAll();
	    
	    List<CardType> cardTypesVacios = (List<CardType>) cardTypeService.findAll();
	    assertTrue(cardTypesVacios.isEmpty());
	    
	    cardTypeService.saveAll(cardTypesAnteriores);
	    
	    List<CardType> cardTypesRestaurados = (List<CardType>) cardTypeService.findAll();
	    assertFalse(cardTypesRestaurados.isEmpty());
	    assertEquals(cardTypesAnteriores.size(), cardTypesRestaurados.size());
	}
	

	
}



















