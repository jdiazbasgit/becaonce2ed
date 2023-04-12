package once.curso.banco.bancoentityes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="fees")
public class Fee {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private double current;
}
