package once.curso.ejemplojpa.entities;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;import lombok.Data;
@Data
@Entity
@Table (name = "employees") 
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
private String nif;
private String phone;
private GregorianCalendar birth_date;
private GregorianCalendar date_hight;
private GregorianCalendar low_date;

@ManyToOne
@JoinColumn (name = "personal_information_id")
private PersonalInformation personalInformation;


@ManyToOne
@JoinColumn (name = "laboral_information_id")
private PersonalInformation laboralInformation;


@ManyToOne
@JoinColumn (name = "companies_id")
private Company Company;
}
