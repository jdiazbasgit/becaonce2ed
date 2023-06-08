package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		return getCardTypeCRUDRepository().save(entity);
	}

	public Iterable<CardType> saveAll(Iterable<CardType> entities) {
		return getCardTypeCRUDRepository().saveAll(entities);
	}

	public Optional<CardType> findById(Integer id) {
		return getCardTypeCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getCardTypeCRUDRepository().existsById(id);
	}

	public Iterable<CardType> findAll() {
		return getCardTypeCRUDRepository().findAll();
	}

	public Page<CardType> findAll(Pageable pageable){
		return getCardTypeCRUDRepository().findAll(pageable);
	}
	
	
	public Iterable<CardType> findAllById(Iterable<Integer> ids) {
		return getCardTypeCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getCardTypeCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getCardTypeCRUDRepository().deleteById(id);
	}

	public void delete(CardType entity) {
		getCardTypeCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getCardTypeCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends CardType> entities) {
		getCardTypeCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getCardTypeCRUDRepository().deleteAll();
	}

}
