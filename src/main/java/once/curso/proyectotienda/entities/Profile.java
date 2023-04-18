package once.curso.proyectotienda.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="profiles")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String second_name;
	
	private String identification;
	
	private String creditcard;
	
	private String address;
	
	private String postalcode;
	
	private String country;
	
	private String email;
	
	private String city;
	
	private String phone;
	
	private String image;
	
	@ManyToOne
	@JoinColumn (name="Users_id")
	private User Users;
	
	@ManyToOne
	@JoinColumn (name="Card_Types_Id")
	private CardType cardstypes;
	
	@ManyToOne
	@JoinColumn (name="Document_Types_Id")
	private DocumentType documentstypes;
}
