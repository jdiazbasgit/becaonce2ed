package once.curso.ejemplojpa;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Prueba {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(5);
		for(int i=0;i<10;i++)
		System.out.println(encoder.encode("1"));
		System.out.println(encoder.matches("1234", "$2a$05$TH/f.LFha6eLtzLssev1se7N9EsRyVx7KMpwAKMNKgz3kE/MEn8EW"));
System.out.println(encoder.matches("2", "$2a$05$iiWh8JJuJzA6yOgs5fk73eDSk6gdGiSuY7o7T6zi.NLvTYBMpAMXW"));
	}

}
