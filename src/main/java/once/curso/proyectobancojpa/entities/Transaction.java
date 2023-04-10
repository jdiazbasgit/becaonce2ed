package once.curso.proyectobancojpa.entities;

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
@Table(name = "TRANSACTIONS")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "current")
	private double current;

	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Calendar date;

	@ManyToOne
	@JoinColumn(name = "descriptions_id")
	private Description description;

	@ManyToOne
	@JoinColumn(name = "current_accounts_id")
	private CurrentAccount currentAccount;

}
