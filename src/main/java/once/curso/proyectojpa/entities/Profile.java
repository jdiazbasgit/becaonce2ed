package once.curso.proyectojpa.entities;

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
@Table(name = "PROFILES")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String secondName;
	private String identication;
	private String creditCard;
	private String address;
	private String postalCode;
	private String country;
	private String email;
	private String city;
	private String phone;
	private byte image;

	@ManyToOne
	@JoinColumn(name = "USERS_ID")
	private int user;

	@ManyToOne
	@JoinColumn(name = "CARD_TYPES_ID")
	private int cardTypes;

	@ManyToOne
	@JoinColumn(name = "DOCUMENT_TYPES_ID")
	private int documentType;

}
