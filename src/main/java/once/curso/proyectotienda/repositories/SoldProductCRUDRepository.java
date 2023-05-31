package once.curso.proyectotienda.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import once.curso.proyectotienda.entities.SoldProduct;

@Repository
public interface SoldProductCRUDRepository extends PagingAndSortingRepository<SoldProduct, Integer>{}
