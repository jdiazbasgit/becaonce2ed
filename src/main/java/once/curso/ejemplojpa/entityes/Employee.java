package once.curso.ejemplojpa.entityes;

import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data 
@Entity
@Table (name="employees")
public class Employee {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String nif;
	private String phone;
	
	@Column (name="birth_date")
	@Temporal(TemporalType.DATE)
	private GregorianCalendar birthDate;
	
	@Column (name="date_hight")
	@Temporal(TemporalType.DATE)
	private GregorianCalendar dateHight;
	
	@Column (name="low_date")
	@Temporal(TemporalType.DATE)
	private GregorianCalendar lowDate;
	
	@ManyToOne
	@JoinColumn (name="personal_information_id")
	private PersonalInformation personalInformation;
	
	@ManyToOne
	@JoinColumn (name="laboral_information_id")
	private LaboralInformation laboralInformation;
	
	@ManyToOne
	@JoinColumn (name="companies_id")
	private Company company;
	
	

}
