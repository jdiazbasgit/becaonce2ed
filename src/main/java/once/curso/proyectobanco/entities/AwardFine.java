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
@Table(name = "awards_fines") 
public class AwardFine extends RepresentationModel<AwardFine> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "awards_fines_types_id")
	private AwardFineType awardFineType;
	@ManyToOne
	@JoinColumn(name = "awards_fines_configurations_id")
	private AwardFineConfiguration awardFineConfiguration;
	private int time;
}

