package once.curso.proyectotienda.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.support.PagingAndSortingTemplateVariables;
import org.springframework.stereotype.Repository;

import once.curso.proyectotienda.entities.User;


@Repository
public interface UserCRUDRepository extends PagingAndSortingRepository<User, Integer> {

	@Query("from User as u where u.user=:username")
	public User loadUserByUsername(String username);

}
