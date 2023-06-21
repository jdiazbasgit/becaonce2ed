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
	private byte[] imagen;
	private int identificationType;
	private String user;
	private String password;
	
}