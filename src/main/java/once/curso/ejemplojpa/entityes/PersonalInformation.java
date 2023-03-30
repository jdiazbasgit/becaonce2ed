package once.curso.ejemplojpa.entityes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;

@Data
@Entity
@Table(name="personal_Information")
public class PersonalInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@Column
	private Child childrenId;
	
	
	@ ManyToOne
	@Column(name="marital_statuses_id")
	private MaritalStatus maritalStatus;
		
	}


