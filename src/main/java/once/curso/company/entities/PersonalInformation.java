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
@Table (name = "personal_information") 
public class PersonalInformation {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@ManyToOne
@JoinColumn(name = "children_id")
private Child child;
@ManyToOne
@JoinColumn(name = "marital_statuses_id")
private MaritalStatus maritalStatus;
}
