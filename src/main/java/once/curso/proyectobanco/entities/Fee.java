package once.curso.proyectobanco.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "fees")
public class Fee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double current;
}
