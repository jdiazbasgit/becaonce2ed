package once.curso.banco.bancoentityes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="roles")
public class Rol {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String rol;
	
	
	

}