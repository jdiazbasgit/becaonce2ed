package once.curso.proyectobanco.repositories;


import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.TimingType;


import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface TimingTypeCRUDRepository extends PagingAndSortingRepository<TimingType, Integer> {

	
}
