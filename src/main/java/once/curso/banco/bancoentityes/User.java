package once.curso.banco.bancoentityes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="users")
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String user;
	private String password;
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn (name="roles_id")
	private Rol rol;
	
	

}
