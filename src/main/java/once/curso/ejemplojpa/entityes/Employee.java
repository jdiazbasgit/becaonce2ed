package once.curso.ejemplojpa.entityes;

import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.xml.bind.v2.runtime.Name;

import lombok.Data;




@Data
@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String nif;
	private String phone;
	
	@Column (name="birth_date")
	private GregorianCalendar birthDate ;
	
	@Column (name="date_hight")
	private GregorianCalendar dateHight;
	
	@Column (name="low_date")
	private GregorianCalendar lowDate;
	
	@Column (name="personal_information_id")
	private PersonalInformation personalInformtion;
	
	@Column (name="laboral_information_id")
	private LaboralInformation LaboralInformation;
	
	@Column (name="companies_id")
	private Company companies;
	
	
	
	
	
	
	
	
	
}
