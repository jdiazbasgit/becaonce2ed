package once.curso.ejemplojpa.entityes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Entity
@Data
@Table(name = "children")
public class Child extends RepresentationModel<Child> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "guys")
	private int guy;
	
	@Column(name = "girls")
	private int girl;
	
}
