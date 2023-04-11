package once.curso.proyectojpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectojpa.entities.Organization;
import once.curso.proyectojpa.repositories.OrganizationRepository;

@Data
@Service
public class OrganizationService {
	@Autowired
	private OrganizationRepository organizationRepository;

	public void dameOrganizaciones() {
		Iterable<Organization> dameOrganizaciones = getOrganizationRepository().findAll();
		for (Organization organization : dameOrganizaciones) {
			System.out.println(organization.getStockAlarm());
		}

	}

	public <S extends Organization> S save(S entity) {
		return getOrganizationRepository().save(entity);
	}

	public <S extends Organization> Iterable<S> saveAll(Iterable<S> entities) {
		return getOrganizationRepository().saveAll(entities);
	}

	public Optional<Organization> findById(Integer id) {
		return getOrganizationRepository().findById(id);
	}

	public boolean existsById(Integer id) {
		return getOrganizationRepository().existsById(id);
	}

	public Iterable<Organization> findAll() {
		return getOrganizationRepository().findAll();
	}

	public Iterable<Organization> findAllById(Iterable<Integer> ids) {
		return getOrganizationRepository().findAllById(ids);
	}

	public long count() {
		return getOrganizationRepository().count();
	}

	public void deleteById(Integer id) {
		getOrganizationRepository().deleteById(id);
	}

	public void delete(Organization entity) {
		getOrganizationRepository().delete(entity);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		getOrganizationRepository().deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Organization> entities) {
		getOrganizationRepository().deleteAll(entities);
	}

	public void deleteAll() {
		getOrganizationRepository().deleteAll();
	}
}
