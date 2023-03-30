package once.curso.ejemplojpa.entities;

import javax.persistence.Column;
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
	//aunque además de name se pueden dar más limitaciones para que haga la comprobación sobre el objeto antes
	//de que lo compruebe contra la BBDD y esta lo rebote. Como la longitud de un VARCHAR
	@Column (length = 45)
	private String description;

}
