package once.curso.ejemplojpa.entityes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data   //es por lombok
@Entity   //Entidad comprobamos que los datos coincidan con BBDD, tiene que tener las mismas propiedades que campos tiene la tabla.
@Table(name="laboral_information")
public class LaboralInformation {
	
	@Id   // diremos  a JPA que es clave primaria.
	@GeneratedValue(strategy = GenerationType.AUTO)   //diremos la clave primaria y si es autoincremental.
	
	
	private int id; //numerico
	
	
	private int salary;  //numerico
	
	
	@ManyToOne
	@JoinColumn(name = "charges_id") //tiene un cargos_id que es una "Relacion Foranea" con la tabla Cargos,
	private Charge charge;           //entonces en la parte de objetos le decimos que es una entidad, que la tabla se llama asi y 
	                                  //que este es " el ID " y es AUTOINCREMENTAL ademas tiene un campo int que se llama salario
}                                      //y tiene un campo de objeto cargo con una relacion de ManyToOne y la columna de enganche es cargos_Id
                                       //esta es la COLUMNA para que JPA conozca las relacion es FORANEAS