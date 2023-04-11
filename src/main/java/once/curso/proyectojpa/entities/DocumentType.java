package once.curso.proyectojpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "DOCUMENT_TYPES")
public class DocumentType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description;

}
