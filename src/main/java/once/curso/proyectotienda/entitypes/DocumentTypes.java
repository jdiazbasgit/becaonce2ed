package once.curso.proyectotienda.entitypes;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DocumentTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", length = 20, nullable = false)
	private int id;
	
	@Column(name = "Description")
	private String description;
}
