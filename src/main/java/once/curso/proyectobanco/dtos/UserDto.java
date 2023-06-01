package once.curso.proyectobanco.dtos;

import java.util.Set;

import lombok.Data;
import once.curso.proyectobanco.entities.Rol;

@Data
public class UserDto {
	
	private String user;
	private String token;
	private Set<Rol> roles;

}
