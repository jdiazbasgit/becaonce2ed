package once.curso.proyectotienda.dtos;

import lombok.Data;

@Data
public class ProfileDto {
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
	private byte[] image;
	private int cardType;
	private int documentType;
	private String user;
	private String password;
	
	public ProfileDto(String name, String secondName, String identification, String creditCard, String address, 
			String postalCode, String country, String email, String city, String phone, byte[] image, int cardTypes,
			int documentType, String user, String password) {
		super();
		this.name = name;
		this.secondName = secondName;
		this.identification = identification;
		this.creditCard = creditCard;
		this.address = address;
		this.postalCode = postalCode;
		this.country = country;
		this.email = email;
		this.city = city;
		this.phone = phone;
		this.image = image;
		this.cardType = cardTypes;
		this.documentType = documentType;
		this.user = user;
		this.password = password;
	}
	
}
