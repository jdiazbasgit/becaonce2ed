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
@Table (name="transactions")
public class Transaction extends RepresentationModel<Transaction> {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Calendar date;
	
	private double current;
	
	@ManyToOne
	@JoinColumn (name="descriptions_id")
	private Description description;
	
	@ManyToOne
	@JoinColumn (name="currents_accounts_id")
	private CurrentAccount currentAccount;

			
	

}
