package once.curso.proyectotienda;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.entities.CardType;
import once.curso.proyectotienda.repositories.CardTypeCRUDRepository;
import once.curso.proyectotienda.services.CardTypeService;

@SpringBootTest
@Data
public class CardTypeTest {

	
	@Autowired
	private CardTypeCRUDRepository cardTypeCRUDRepository;
	
	@Autowired
	private CardTypeService cardTypeService;

	@Test
	public void findAll() {
		List<CardType> cardType = (List<CardType>) getCardTypeService().findAll();
		assertNotEquals(cardType.size(), 0);
	}

	@Test
	public void probarSaveFindDelete() {
		CardType cardType = new CardType();
		cardType.setDescription("pruebac");
		getCardTypeService().save(cardType);
		CardType cardTypeRecuperado = getCardTypeService().findById(cardType.getId()).get();
		getCardTypeService().delete(cardTypeRecuperado);
		
		assertFalse(getCardTypeService().existsById(cardType.getId()));

	}
    @Test
    public void probarSaveAllDeleteAll() {
    	Long cantidadAlEmpezar=getCardTypeService().count();
    	List<CardType> cardTypes = new ArrayList<CardType>();
		CardType cardTypePrueba1 =new CardType();
    	cardTypePrueba1.setDescription("pruebaA");
		cardTypes.add(cardTypePrueba1);
		
		CardType cardTypePrueba2 =new CardType();
		cardTypePrueba2.setDescription("pruebaB");
		cardTypes.add(cardTypePrueba2);
		
		getCardTypeService().saveAll(cardTypes);
		assertEquals(getCardTypeService().count(),cantidadAlEmpezar+2);
        
    	 	

    }

}












































