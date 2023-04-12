package once.curso.banco.bancoentityes;

import java.util.Calendar;

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
@Table (name="AWARDS_FINES")
public class AwardFine {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn (name="AWARDS_FINES_TYPES_ID")
	private AwardFineType awardFineType;
	
	@ManyToOne
	@JoinColumn (name="AWARDS_FINES_CONFIGURATIONS_ID")
	private AwardFineConfiguration awardFineConfiguration;
	
	@Temporal(TemporalType.DATE)
	private Calendar time;

}
