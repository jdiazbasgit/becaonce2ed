package once.curso.banco.bancoentityes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="type_Accounts")
public class TypeAccount {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String description;
}
