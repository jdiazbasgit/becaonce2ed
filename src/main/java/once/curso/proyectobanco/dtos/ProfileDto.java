package once.curso.proyectobanco.dtos;
import java.util.Set;
import lombok.Data;
import once.curso.proyectobanco.entities.IdentificationType;
import once.curso.proyectobanco.entities.User;

@Data
public class ProfileDto {

	private String name;
	private String secondName;
	private String identification;
	private String email;
	private String phone;
	private byte[] image;
	private int identificationType;
	private String user;
	private String password;
	
	
	public ProfileDto(String name, String secondName, String identification, String email, String phone, byte[] image,
			int identificationType, String user, String password) {
		super();
		this.name = name;
		this.secondName = secondName;
		this.identification = identification;
		this.email = email;
		this.phone = phone;
		this.image = image;
		this.identificationType = identificationType;
		this.user = user;
		this.password = password;
	}
	
	
    
}
