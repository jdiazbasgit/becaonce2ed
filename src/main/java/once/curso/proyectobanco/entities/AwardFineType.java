package once.curso.proyectobanco.entities;

import org.springframework.hateoas.RepresentationModel;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "awards_fines_types") 
public class AwardFineType extends RepresentationModel<AwardFineType> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 45)
	private String description;
}
