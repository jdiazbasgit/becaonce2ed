package once.curso.proyectotienda.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.CardType;
import once.curso.proyectotienda.services.CardTypeService;

@RestController
@Data
@RequestMapping({"/once"})
public class CardTypeRestController {
	
	
	@Autowired
	private CardTypeService cardTypeService;

	@CrossOrigin(origins = "*")
	@PostMapping("/cardTypes")
	public CardType save(@RequestBody CardType cardType) {
		return getCardTypeService().save(cardType);
	}

	@GetMapping("/cardTypes{id}")
	@CrossOrigin(origins = "*")
	public EntityModel<CardType> findById(@PathVariable int id) {
		CardType cardType = getCardTypeService().findById(id).get();
		cardType.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(CardTypeRestController.class).findById(cardType.getId()))
				.withSelfRel());

		return EntityModel.of(cardType);
	}

	@GetMapping("/cardTypes")
	@CrossOrigin(origins = "*")
	public CollectionModel<CardType> findAll() {
		Iterable<CardType> cardTypes = getCardTypeService().findAll();
		cardTypes.forEach(c -> {
			c.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CardTypeRestController.class).findById(c.getId()))
					.withSelfRel());
		});
		return CollectionModel.of(cardTypes);
	}

	@DeleteMapping("/cardTypes/{id}")
	@CrossOrigin(origins = "*")
	public void deleteById(@PathVariable int id) {
		getCardTypeService().deleteById(id);
	}

}
