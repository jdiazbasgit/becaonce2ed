package once.curso.proyectobanco.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
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
	
	public List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();

        entityManager.getMetamodel().getEntities().forEach(entity -> {
            ClassMetadata classMetadata = sessionFactory.getClassMetadata(entity.getJavaType());
            tableNames.add(classMetadata.getEntityName());
        });
        return tableNames;
    }

	public Optional<MappingFKDescription> findById(Integer id) {
		return getMappingFKDescriptionCRUDRepository().findById(id);
	}

	public Iterable<MappingFKDescription> findAll() {
		return getMappingFKDescriptionCRUDRepository().findAll();
	}
	
	public Iterable<MappingFKDescription> findAllById(Iterable<Integer> ids) {
		return getMappingFKDescriptionCRUDRepository().findAllById(ids);
	}

	public long count() {
		return getMappingFKDescriptionCRUDRepository().count();
	}

}