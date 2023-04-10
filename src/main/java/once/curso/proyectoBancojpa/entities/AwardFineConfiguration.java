package once.curso.proyectoBancojpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "AWARDS_FINES_CONFIGURATIONS")
public class AwardFineConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String current;
	private String description;
}
