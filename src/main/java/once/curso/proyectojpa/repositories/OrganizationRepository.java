package once.curso.proyectojpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectojpa.entities.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Integer> {

}
