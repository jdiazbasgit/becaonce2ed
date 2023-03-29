package once.curso.ejemplojpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="charges")
public class Charge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	//@Column(name="description") cuando la propiedad no coincide con el nombre, en este caso no es necesario
	//pero si fuera description_id entonces si
	private String description;

}
