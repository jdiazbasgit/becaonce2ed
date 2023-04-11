package once.curso.company.entities;
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
@Table (name = "laboral_information") 
public class LaboralInformation {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private int salary;
@ManyToOne
@JoinColumn(name = "charges_id")
private Charge charge;
}
