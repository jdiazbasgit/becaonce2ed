package once.curso.proyectotienda.dtos;

import lombok.Data;

@Data
public class ProfileUserDto {
	
	private boolean identification;
	private boolean credit_card;
	private boolean email;
	private boolean phone;
	private boolean user;

}
