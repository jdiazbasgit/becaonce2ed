package once.curso.ejemplojpa.entityes;

import java.util.GregorianCalendar;

import javax.persistence.Column;
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
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String nif;
	private String phone;
	
	private GregorianCalendar birthDate;
	private GregorianCalendar dateHight;
	private GregorianCalendar lowDate;
	
	@ManyToOne
	@JoinColumn(name="personal_information_id")
	private int personalInformation;

	@ManyToOne
	@JoinColumn(name="laboral_information_id")
	private int laboralInformation;
	
	@ManyToOne
	@JoinColumn(name="companies_id")
	private int company;
	

}
