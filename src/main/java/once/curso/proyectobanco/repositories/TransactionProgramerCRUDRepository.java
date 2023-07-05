package once.curso.proyectobanco.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.TransactionProgramer;

@Repository
public interface TransactionProgramerCRUDRepository extends PagingAndSortingRepository<TransactionProgramer, Integer>{

	
}
