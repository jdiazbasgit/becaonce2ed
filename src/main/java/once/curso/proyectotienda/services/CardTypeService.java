package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.CardType;
import once.curso.proyectotienda.repositories.CardTypeCRUDRepository;

@Service
@Data
public class CardTypeService {
	@Autowired
	private CardTypeCRUDRepository cardTypeCRUDRepository;

	public Iterable<CardType> getCardType() {
		return getCardTypeCRUDRepository().findAll();
	}

	public CardType save(CardType entity) {
//HECHO
		return getCardTypeCRUDRepository().save(entity);
	}

	public Iterable<CardType> saveAll(Iterable<CardType> entities) {
//HECHO
		return getCardTypeCRUDRepository().saveAll(entities);
	}

	public Optional<CardType> findById(Integer id) {
//HECHO
		return getCardTypeCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
//HECHO
		return getCardTypeCRUDRepository().existsById(id);
	}

	public Iterable<CardType> findAll() {
//HECHO
		return getCardTypeCRUDRepository().findAll();
	}

	public Iterable<CardType> findAllById(Iterable<Integer> ids) {
//HECHO
		return getCardTypeCRUDRepository().findAllById(ids);
	}

	public long count() {
//HECHO
		return getCardTypeCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		//HECHO
		getCardTypeCRUDRepository().deleteById(id);
	}

	public void delete(CardType entity) {
		//HECHO
		getCardTypeCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		//HECHO
		getCardTypeCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends CardType> entities) {
		//HECHO
		getCardTypeCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getCardTypeCRUDRepository().deleteAll();
	}

}
