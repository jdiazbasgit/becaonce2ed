package once.curso.ejemplojpa.entityes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "companies")
@Data
public class Company {

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String cif;
	private String description;
	
}
