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
import once.curso.proyectobanco.entities.Description;
import once.curso.proyectobanco.entities.CurrentAcount;

import lombok.Data;

@Data
@Entity
@Table (name="transactions")
public class Transaction {
	  
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
	@JoinColumn (name="current_accounts_id)"
			private CurrentAcount currentAccount;

			
	

}
