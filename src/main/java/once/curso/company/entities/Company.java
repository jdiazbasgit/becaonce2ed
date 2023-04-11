package once.curso.company.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Data;
@Data
@Entity
@Table (name = "companies") 
public class Company {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Column (length = 9)
private String cif;
@Column (length = 200)
private String description;
}
