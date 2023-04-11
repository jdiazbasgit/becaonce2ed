package once.curso.company.entities;
import javax.persistence.Column;
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Data;
@Data
@Entity
@Table (name = "employees") 
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Column (length = 45)
private String name;
@Column (length = 45)
private String nif;
@Column (length = 45)
private String phone;
@Temporal (TemporalType.DATE)
private Calendar birthDate;
@Temporal (TemporalType.DATE)
private Calendar dateHight;
@Temporal (TemporalType.DATE)
private Calendar lowDate;
@ManyToOne
@JoinColumn(name = "personal_information_id")
private PersonalInformation personalInformation;
@ManyToOne
@JoinColumn(name = "laboral_information_id")
private LaboralInformation laboralInformation;
@ManyToOne
@JoinColumn(name = "companies_id")
private Company company;
}
