package once.curso.proyectobanco.entities;

import org.springframework.hateoas.RepresentationModel;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "awards_fines_configurations") 
public class AwardFineConfiguration extends RepresentationModel<AwardFineConfiguration> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double current;
	@ManyToOne
	@JoinColumn(name = "descriptions_id")
	private Description description;
}