package once.curso.ejemplojpa.entityes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.context.annotation.Lazy;

import lombok.Data;

@Data
@Entity
@Table(name="laboral_information")
public class LaboralInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	private int salary;
	
	
	@ManyToOne
	@JoinColumn(name = "charges_id")
	private Charge charge;
	
}
