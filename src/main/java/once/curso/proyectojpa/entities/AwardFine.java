package once.curso.proyectojpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "awards_fines")
public class AwardFine {

	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "awards_fines_types_id")
	private int awardsFinesTypes;

	@Column(name = "awards_fies_configurations_id")
	private int awardsFiesConfigurations;

	private int time;

}
