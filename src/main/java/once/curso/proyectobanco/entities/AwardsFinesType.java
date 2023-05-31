package once.curso.proyectobanco.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "awards_fines_types")
public class AwardsFinesType extends RepresentationModel <AwardsFinesType>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description;

}
