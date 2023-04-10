package bancoEntityes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="transactions_awards_fines")
public class TransactionAwardFine {
	
	@ManyToOne
	@JoinColumn (name="transactions_id")
private Transaction transaction;
	
	@ManyToOne
	@JoinColumn (name="awards_fines_types_id")
	private AwardFineType awardFineType;
}
