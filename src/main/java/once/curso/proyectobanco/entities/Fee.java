package once.curso.proyectobanco.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
@Entity
@Table(name = "fees")

public class Fee extends RepresentationModel<Fee>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double current;
}

