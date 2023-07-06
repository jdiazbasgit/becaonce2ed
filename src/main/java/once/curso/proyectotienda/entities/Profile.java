package once.curso.proyectotienda.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
@Entity
@Table(name="profiles")
public class Profile extends RepresentationModel<Profile>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String secondName;
	private String identification;
	private String creditCard;
	private String address;
	private String postalCode;
	private String country;
	private String email;
	private String city;
	private String phone;
	
	@Lob
	private byte[] image;
	
	@ManyToOne
	@JoinColumn (name="Users_id")
	private User user;
	
	@ManyToOne
	@JoinColumn (name="card_types_Id")
	private CardType cardType;
	
	@ManyToOne
	@JoinColumn (name="Document_Types_Id")
	private DocumentType documentType;
}



