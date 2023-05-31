package once.curso.proyectobanco.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.User;


@Repository
public interface UserCRUDRepository extends PagingAndSortingRepository<User, Integer> {

	@Query("from User as u where u.user=:username")
	public User loadUserByUsername(String username);


	
}
