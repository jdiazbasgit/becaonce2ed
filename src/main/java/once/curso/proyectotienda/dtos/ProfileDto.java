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
	private int cardtType;
	private int documentType;
	private String user;
	private String password;
	
	public ProfileDto(String name, String secondName, String identification, String creditcard, String address, String postalcode, String country, String city, String email, String phone, byte[] image, String user, String password) {
		super();
		this.name = name;
		this.secondName = secondName;
		this.identification = identification;
		this.email = email;
		this.phone = phone;
		this.image = image;
		this.identification = identification;
		this.creditCard = creditcard;
		this.address = address;
		this.postalCode = postalcode;
		this.country = country;
		this.city = city;
		this.user = user;
		this.password = password;
	}    
}
