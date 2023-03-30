package once.curso.ejemplojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.ejemplojpa.entityes.PersonalInformation;
import once.curso.ejemplojpa.repositories.PersonalInformationRepository;

@Service
@Data
public class PersonalInformationService {

	@Autowired
	private PersonalInformationRepository personalInformationRepository;

	public void dameDatosPersonales() {
		Iterable<PersonalInformation> datosPersonales = getPersonalInformationRepository().findAll();
		for (PersonalInformation personalInformation : datosPersonales) {
			System.out.println(personalInformation.getChildren());
			System.out.println(personalInformation.getMaritalStatus());

		}

	}

	public <S extends PersonalInformation> S save(S entity) {
		return getPersonalInformationRepository().save(entity);
	}

	public <S extends PersonalInformation> Iterable<S> saveAll(Iterable<S> entities) {
		return getPersonalInformationRepository().saveAll(entities);
	}

	public Optional<PersonalInformation> findById(Integer id) {
		return getPersonalInformationRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getPersonalInformationRepository().existsById(id);
	}

	public Iterable<PersonalInformation> findAll() {
		return getPersonalInformationRepository().findAll();
	}

	public Iterable<PersonalInformation> findAllById(Iterable<Integer> ids) {
		return getPersonalInformationRepository().findAllById(ids);
	}

	public long count() {
		return getPersonalInformationRepository().count();
	}

	public void deleteById(Integer id) {
		getPersonalInformationRepository().deleteById(id);
	}

	public void delete(PersonalInformation entity) {
		getPersonalInformationRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getPersonalInformationRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends PersonalInformation> entities) {
		getPersonalInformationRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getPersonalInformationRepository().deleteAll();
	}

}
