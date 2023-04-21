package once.curso.proyectobanco.entities;

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
@Table(name = "awards_fines")
public class AwardsFine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "awards_fines_types_id")
	private AwardsFinesType awardFineType;

	@ManyToOne
	@JoinColumn(name = "awards_fines_configurations_id")
	private AwardsFinesConfiguration awardFineConfiguration;
	
	private int time;

}
