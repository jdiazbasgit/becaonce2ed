package once.curso.proyectobanco.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
@Entity
@Table (name="configurations")
public class Configuration  extends RepresentationModel<Configuration>{

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	@Column (name="Live_Time")
	private int liveTime;
	
}