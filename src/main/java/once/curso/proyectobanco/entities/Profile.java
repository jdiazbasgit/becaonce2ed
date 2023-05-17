package once.curso.proyectobanco.entities;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "profiles")
public class Profile extends RepresentationModel<Profile>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 45)
	private String name;
	@Column(length = 100)
	private String secondName;
	@Column(length = 45)
	private String identification;
	@Column(length = 100)
	private String email;
	@Column(length = 45)
	private String phone;
	private byte[] image;
	@ManyToOne
	@JoinColumn(name = "identification_types_id")
	private IdentificationType identificationType;
	@ManyToOne
	@JoinColumn(name = "users_id")
	private User user;
}
