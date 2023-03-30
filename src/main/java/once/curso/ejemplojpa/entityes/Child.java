package once.curso.ejemplojpa.entityes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="children")
public class Child {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	@Column(name="guys")
	private int guys;
	@Column (name="girls")
	private int girl;

}
