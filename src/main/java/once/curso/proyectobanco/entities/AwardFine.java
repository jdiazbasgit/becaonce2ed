package once.curso.proyectobanco.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "awards_fines")
public class AwardFine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "awards_fines_types_id")
	private AwardsFinesType awardsFinesType;

	@ManyToOne
	@JoinColumn(name = "awards_fines_configurations_id")
	private AwardsFinesConfiguration awardsFinesConfiguration;

	@Column(name = "time")
	@Temporal(TemporalType.DATE)
	private Calendar time;

}
