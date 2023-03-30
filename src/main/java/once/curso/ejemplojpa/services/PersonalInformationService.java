package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.PersonalInformation;
import once.curso.ejemplojpa.repositories.PersonalInformationCRUDRepository;

@Service
@Data
public class PersonalInformationService {

	@Autowired
	private PersonalInformationCRUDRepository personalInformationCRUDRepository;

	public void DatosPersonales() {

		Iterable<PersonalInformation> datosPersonales = getPersonalInformationCRUDRepository().findAll();
		for (PersonalInformation personalInformationCRUDRepository : datosPersonales) {
			System.out.println(personalInformationCRUDRepository.getChild());
			System.out.println(personalInformationCRUDRepository.getMaritalStatus());

		}

	}

	public <S extends PersonalInformation> S save(S entity) {
		return getPersonalInformationCRUDRepository().save(entity);
	}

	public <S extends PersonalInformation> Iterable<S> saveAll(Iterable<S> entities) {
		return getPersonalInformationCRUDRepository().saveAll(entities);
	}

	public Optional<PersonalInformation> findById(Integer id) {
		return getPersonalInformationCRUDRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getPersonalInformationCRUDRepository().existsById(id);
	}

	public Iterable<PersonalInformation> findAll() {
		return getPersonalInformationCRUDRepository().findAll();
	}

	public Iterable<PersonalInformation> findAllById(Iterable<Integer> ids) {
		return getPersonalInformationCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getPersonalInformationCRUDRepository().count();
	}

	public void deleteById(Integer id) {
		getPersonalInformationCRUDRepository().deleteById(id);
		;
	}

	public void delete(PersonalInformation entity) {
		getPersonalInformationCRUDRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getPersonalInformationCRUDRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends PersonalInformation> entities) {
		getPersonalInformationCRUDRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getPersonalInformationCRUDRepository().deleteAll();
	}
}
