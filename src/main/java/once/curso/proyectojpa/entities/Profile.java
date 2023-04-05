package once.curso.proyectojpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Profiles")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@Column(name = "second_name")
	private String secondName;

	private String identification;
	private String email;
	private String phone;
	private String image;

	@Column(name = "identification_types_id")
	private int IdentificationType;

	@Column(name = "users_id")
	private int user;

}
