package once.curso.proyectotienda;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CrearClave {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(5);
		System.out.println(encoder.encode("1234"));
	}

}
