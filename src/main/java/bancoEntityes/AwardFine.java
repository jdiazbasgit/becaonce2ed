package bancoEntityes;

import java.sql.Time;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table (name="awards_fines")
public class AwardFine {
	
	
	private AwardFineType awardFineType;
	private AwardFineConfiguration awardFineConfiguration;
	
	@Temporal(TemporalType.TIME)
	private Calendar time;

}
