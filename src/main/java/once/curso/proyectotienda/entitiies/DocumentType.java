package once.curso.proyectotienda.entitiies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
@Entity
@Table(name = "document_types")
public class DocumentType {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;

	public String description;

}
