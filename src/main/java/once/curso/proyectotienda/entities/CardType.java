package once.curso.proyectotienda.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

<<<<<<< HEAD


=======
>>>>>>> feature/develop-tienda-dlg
import lombok.Data;

@Data
@Entity
@Table(name="Card_Type")
public class CardType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String description;

}
