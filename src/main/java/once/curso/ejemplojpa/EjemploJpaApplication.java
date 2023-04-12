package once.curso.ejemplojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;

@SpringBootApplication
@Data
public class EjemploJpaApplication  {

	
	
	public static void main(String[] args) {
		SpringApplication.run(EjemploJpaApplication.class, args);
		
	}

	
}
