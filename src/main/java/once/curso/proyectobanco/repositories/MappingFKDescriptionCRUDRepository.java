package once.curso.proyectobanco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import once.curso.proyectobanco.entities.MappingFKDescription;
import once.curso.proyectobanco.entities.Transaction;

@Repository
public interface MappingFKDescriptionCRUDRepository extends CrudRepository<MappingFKDescription, Integer> {
	

	//Pruebas
	//@Query("SELECT SUM(t.current) FROM Transaction t WHERE t.currentAccount.number = :numeroCuenta")
	//public int getSaldo(int numeroCuenta);
	
}
