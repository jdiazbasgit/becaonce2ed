package once.curso.proyectobanco.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "identifications_types")
public class IdentificationType extends RepresentationModel<IdentificationType>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 45)
	private String description;
}
