package once.curso.proyectotienda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entity.CardType;
import once.curso.proyectotienda.repository.CardTypeRepository;

@Service
@Data
public class CardTypeService {
	@Autowired
	private CardTypeRepository cardTypeRepository;

	public Iterable<CardType> getCardType() {
		return getCardTypeRepository().findAll();
	}

	public <S extends CardType> S save(S entity) {

		return getCardTypeRepository().save(entity);
	}

	public <S extends CardType> Iterable<S> saveAll(Iterable<S> entities) {

		return getCardTypeRepository().saveAll(entities);
	}

	public Optional<CardType> findById(Integer id) {

		return getCardTypeRepository().findById(id);
	}

	public boolean existsById(Integer id) {

		return getCardTypeRepository().existsById(id);
	}

	public Iterable<CardType> findAll() {

		return getCardTypeRepository().findAll();
	}

	public Iterable<CardType> findAllById(Iterable<Integer> ids) {

		return getCardTypeRepository().findAllById(ids);
	}

	public long count() {

		return getCardTypeRepository().count();
	}

	public void deleteById(Integer id) {
		getCardTypeRepository().deleteById(id);
	}

	public void delete(CardType entity) {
		getCardTypeRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getCardTypeRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends CardType> entities) {
		getCardTypeRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getCardTypeRepository().deleteAll();
	}

}
