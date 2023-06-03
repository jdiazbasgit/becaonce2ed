package once.curso.proyectotienda.dtos;

import java.util.Set;

import lombok.Data;
import once.curso.proyectotienda.entities.Rol;

@Data
public class UserDto {
	
	private String user;
	private String token;
	private Set<Rol> roles;

}
