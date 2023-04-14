package once.curso.proyectotienda.entitypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="profiles")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", length = 20, nullable = false)
	private int id;
	
	@Column(name = "Name", nullable = false)
	private String name;
	
	private String second_name;
	
	@Column(name = "Identification", nullable = false)
	private String identification;
	
	@Column(name = "Credit_Card", nullable = false)
	private String creditcard;
	
	@Column(name = "Address", nullable = false)
	private String address;
	
	@Column(name = "Postal_Code", nullable = false)
	private String postalcode;
	
	@Column(name = "Country", nullable = false)
	private String country;
	
	@Column(name = "Email", nullable = false)
	private String email;
	
	@Column(name = "City", nullable = false)
	private String city;
	
	@Column(name = "Phone", nullable = false)
	private String phone;
	
	private String image;
	
	@OneToOne
	@JoinColumn (name="Users_id")
	private User Users;
	
	@OneToMany
	@JoinColumn (name="Card_Types_Id")
	private CardTypes cardstypes;
	
	@OneToMany
	@JoinColumn (name="Document_Types")
	private DocumentTypes documentstypes;
}
