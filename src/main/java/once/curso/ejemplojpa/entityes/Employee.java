package once.curso.ejemplojpa.entityes;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employees")

public class Employee {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String name;
	private String phone;
	private String nif;

	@JoinColumn(name = "birth_date")
	private Calendar birthDate;
	
	@JoinColumn(name = "date_hight")
	private Calendar dateHight;

	
	@JoinColumn(name = "low_date")
	private Calendar lowCalendar;

	@JoinColumn(name = "personal_information_id")
	private PersonalInformation personaInformation;

	@JoinColumn(name = "laboral_information_id")
	private LaboralInformation laboralInformation;

	@JoinColumn(name = "companies_id")
	private Company company;

}
