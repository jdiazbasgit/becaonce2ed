package once.curso.proyectobanco.entities;

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

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
@Entity
@Table (name="transactions_programers")
public class TransactionProgramer extends RepresentationModel<TransactionProgramer> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double current;
	
	@Temporal(TemporalType.DATE)
	private Calendar dateStart;
	
	@ManyToOne
	@JoinColumn (name="currents_accounts_id")
	private CurrentAccount currentAccount;
	
	@ManyToOne
	@JoinColumn(name="descriptions_id")
	private Description description;
	
	@ManyToOne
	@JoinColumn( name="timings_types_id")
	private TimingType timingType;

	
	}
	
	
		

