package once.curso.ejemplojpa.entityes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Table(name="personal_information")
@Entity
@Data
public class PersonalInformation {
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "children_id")
	private Child child;
	
	
	@ManyToOne
	@JoinColumn(name = "maritalStatuses_id")
	private  MaritalEstatus maritalStatus;

	
	
	

}
