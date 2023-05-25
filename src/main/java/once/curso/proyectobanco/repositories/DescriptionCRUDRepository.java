package once.curso.proyectobanco.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import once.curso.proyectobanco.entities.Description;

public interface DescriptionCRUDRepository extends PagingAndSortingRepository <Description, Integer> {

	

}
