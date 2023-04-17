package once.curso.proyectotienda;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;
import once.curso.proyectotienda.entities.CardType;
import once.curso.proyectotienda.services.CardTypeService;

@SpringBootTest
@Data
public class CardTypeTest {

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
		cardType.setDescription("prueba");
		getCardTypeService().save(cardType);
		CardType cardTypeRecuperado = getCardTypeService().findById(cardType.getId()).get();
		getCardTypeService().delete(cardTypeRecuperado);
		CardType cardTypeBorrado = getCardTypeService().findById(cardType.getId()).get();
		assertNull(cardTypeBorrado);

	}

}
