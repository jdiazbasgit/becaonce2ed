package once.curso.ejemplojpa.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;
@Data
@Entity
@Table (name = "companies") 
public class Company {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String cif;
private String description;
}
