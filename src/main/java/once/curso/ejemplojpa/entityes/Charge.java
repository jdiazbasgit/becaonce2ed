package once.curso.ejemplojpa.entityes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data       //utilizamos @Data por que tenemos que hacer propiedades
@Entity     //significa que es una entidad
@Table(name="charges")    //coge el nombre de la tabla
public class Charge {
	
	@Id //id de la tabla
	@GeneratedValue(strategy = GenerationType.AUTO)// autoIncremental cuando se inserte un registro se grabara y cuando se haga el insert sabra si es autoincremental etc.
	private int id;  // es una propiedad, todos los campos de las tablas son una propiedad
	
	
	//@Column(name="description")
	private String description; //si el nombre de las propiedades coinciden  con el nombre del campo de la tabla no hace falta decirle nada
                                 //si no coincidieran con el nombre del campo pondremos @Colum (name= "despcription")
}
