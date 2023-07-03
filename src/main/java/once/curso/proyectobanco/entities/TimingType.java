package once.curso.proyectobanco.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
@Entity
@Table(name="timings_types")
public class TimingType extends RepresentationModel<TimingType> {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String description;
	private String time;
	
	

}
