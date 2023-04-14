package once.curso.proyectotienda.rest_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entity.CardType;
import once.curso.proyectotienda.services.CardTypeService;

@RestController
@Data
@RequestMapping("/once")
public class CardTypeRestController {
	@Autowired
	private CardTypeService cardTypeService;

	@PostMapping("/cardTypes")
	public CardType save(@RequestBody CardType cardType) {
		return getCardTypeService().save(cardType);
	}

	@GetMapping("/cardTypes")
	public Iterable<CardType> findAll() {
		return getCardTypeService().findAll();
	}

	@DeleteMapping("/cardTypes/{id}")
	public void deleteById(@PathVariable int id) {
		getCardTypeService().deleteById(id);
	}

}
