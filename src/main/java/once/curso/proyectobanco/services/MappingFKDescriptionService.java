package once.curso.proyectobanco.services;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.TableMetaDataProvider;
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

    public void showTables() throws Exception {
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
//        ResultSet esquemas = metaData.getSchemas();
//        while (esquemas.next()) {
//        	System.out.println(esquemas.toString());
//        }
        
        ResultSet tables = metaData.getTables(null, "banco", null, new String[] { "TABLE" });
        while (tables.next()) {
            String tableName=tables.getString("TABLE_NAME");
            System.out.println(tableName);
        }
    }
	
	
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