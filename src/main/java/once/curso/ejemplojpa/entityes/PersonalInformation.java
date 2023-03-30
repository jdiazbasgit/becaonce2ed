package once.curso.ejemplojpa.entityes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
@Table (name="personal_information")
public class PersonalInformation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@Column (name="children_id")
	private Child children;
	
	@ManyToOne
	@Column (name="marital_statuses_id")
	private MaritalStatus maritalStatus;

}
