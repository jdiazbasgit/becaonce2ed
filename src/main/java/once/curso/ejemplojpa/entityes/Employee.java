package once.curso.ejemplojpa.entityes;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String nif;
	
	private String phone;
	
	private Calendar birthdate;
	
	private Calendar datehight;
	
	private Calendar lowdate;
	
	@ManyToOne
	private int personalInformationId;
	
	@ManyToOne
	private int laboralInforamtionId;
	
	@ManyToOne
	private int companiesId;

}
