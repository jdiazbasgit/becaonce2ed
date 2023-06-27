package once.curso.proyectobanco.services;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectobanco.entities.MappingFKDescription;
import once.curso.proyectobanco.repositories.MappingFKDescriptionCRUDRepository;

@Service
@Data
public class MappingFKDescriptionService {

	@Autowired
	private MappingFKDescriptionCRUDRepository mappingFKDescriptionCRUDRepository;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private EntityManager entityManager;
	
    @Autowired
    protected DataSource dataSource;


	public Iterable<MappingFKDescription> findAll() {
		return getMappingFKDescriptionCRUDRepository().findAll();
	}


	public long count() {
		return getMappingFKDescriptionCRUDRepository().count();
	}

}