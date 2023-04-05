package once.curso.proyectojpa.entities;

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
@Table(name = "Transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String current;
	
	@Column (name="date")
	@Temporal (TemporalType.DATE)
	private Calendar date;
	
	@ManyToOne
	@JoinColumn(name="descriptions_id")
	private Description description;
	
	@Column(name="current_accounts_id")
	private int currentAccount;

}
