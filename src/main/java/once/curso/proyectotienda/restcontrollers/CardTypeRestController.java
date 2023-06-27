package once.curso.proyectotienda.restcontrollers;

import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import once.curso.proyectotienda.entities.CardType;
import once.curso.proyectotienda.model.CardTypeModelAssembler;
import once.curso.proyectotienda.services.CardTypeService;

@RestController
@Data
@RequestMapping("/once")
public class CardTypeRestController {

	
	@Autowired
	private CardTypeService cardTypeService;
	
	@Autowired
	private CardTypeModelAssembler cardTypeModelAssembler;

	@Autowired
	private PagedResourcesAssembler<CardType> pagedResourcesAssembler;

	

	@GetMapping("/cardTypes/{id}")
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

	@GetMapping("/cardTypesPaginado")
	@CrossOrigin(origins = "*")
	public PagedModel<EntityModel<CardType>> findAllPaginado(@RequestParam int size, @RequestParam int page,
			@RequestParam String sort) {
		StringTokenizer stringTokenizer = new StringTokenizer(sort, ",");
		Sort orden = Sort.by("a");
		String campo = stringTokenizer.nextToken();
		String tipoOrden = stringTokenizer.nextToken();

		if (tipoOrden.equals("asc"))
			orden = Sort.by(campo).ascending();
		else
			orden = Sort.by(campo).descending();

		Pageable pageable = PageRequest.of(page, size, orden);
		Page<CardType> cardType = getCardTypeService().findAll(pageable);

		return getPagedResourcesAssembler().toModel(cardType, getCardTypeModelAssembler());
	}

	@PostMapping("/cardTypes")
	@CrossOrigin(origins = "*")

	public boolean save(@RequestBody CardType cardType) {
		return existById(getCardTypeService().save(cardType).getId());
	}

	@PostMapping("/cardTypes/{id}")
	@CrossOrigin(origins = "*")
	public boolean existById(@PathVariable int id) {
		return getCardTypeService().existsById(id);
	}

	@DeleteMapping("/cardTypes/{id}")
	@CrossOrigin(origins = "*")
	public boolean deleteById(@PathVariable int id) {
		getCardTypeService().deleteById(id);
		return getCardTypeService().existsById(id);
	}

}
